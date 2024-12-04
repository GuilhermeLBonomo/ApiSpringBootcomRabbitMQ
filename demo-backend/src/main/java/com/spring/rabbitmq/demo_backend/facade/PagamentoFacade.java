package com.spring.rabbitmq.demo_backend.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.rabbitmq.demo_backend.dto.PagamentoDTO;
import com.spring.rabbitmq.demo_backend.producer.PagamentoRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class PagamentoFacade {
    @Autowired private PagamentoRequestProducer producer;
    public String solicitarPagamento(final PagamentoDTO request) {
        try {
            producer.integrar(request);
        } catch (JsonProcessingException e) {
            return MessageFormat.format("Erro ao solicitar pagamento... {0}", e.getMessage());
        }
        return "Pagamento aguardando confirmação...";
    }
    public void erroPagamento(String payload) {
        System.err.println(MessageFormat.format("==== RESPOSTA ERRO ====={0}", payload));
    }

    public void sucessoPagamento(String payload) {
        System.out.println(MessageFormat.format("==== RESPOSTA SUCESSO ====={0}", payload));
    }
}
