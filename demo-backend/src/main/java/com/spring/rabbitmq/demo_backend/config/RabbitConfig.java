package com.spring.rabbitmq.demo_backend.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("localhost");
        factory.setUsername("admin");
        factory.setPassword("admin123");
        return factory;
    }

    // Exchanges
    @Bean
    public DirectExchange pagamentoExchange() {
        return ExchangeBuilder.directExchange("pagamento-request-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange pagamentoResponseErroExchange() {
        return ExchangeBuilder.directExchange("pagamento-response-erro-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange pagamentoResponseSucessoExchange() {
        return ExchangeBuilder.directExchange("pagamento-response-sucesso-exchange")
                .durable(true)
                .build();
    }

    // Queues
    @Bean
    public Queue pagamentoRequestQueue() {
        return new Queue("pagamento-request-queue", true);
    }

    @Bean
    public Queue pagamentoResponseErroQueue() {
        return new Queue("pagamento-response-erro-queue", true);
    }

    @Bean
    public Queue pagamentoResponseSucessoQueue() {
        return new Queue("pagamento-response-sucesso-queue", true);
    }

    // Bindings
    @Bean
    public Binding pagamentoRequestBinding(DirectExchange pagamentoExchange, Queue pagamentoRequestQueue) {
        return BindingBuilder.bind(pagamentoRequestQueue)
                .to(pagamentoExchange)
                .with("pagamento-request-rout-key");
    }

    @Bean
    public Binding pagamentoResponseErroBinding(DirectExchange pagamentoResponseErroExchange, Queue pagamentoResponseErroQueue) {
        return BindingBuilder.bind(pagamentoResponseErroQueue)
                .to(pagamentoResponseErroExchange)
                .with("pagamento-response-erro-rout-key");
    }

    @Bean
    public Binding pagamentoResponseSucessoBinding(DirectExchange pagamentoResponseSucessoExchange, Queue pagamentoResponseSucessoQueue) {
        return BindingBuilder.bind(pagamentoResponseSucessoQueue)
                .to(pagamentoResponseSucessoExchange)
                .with("pagamento-response-sucesso-rout-key");
    }
}
