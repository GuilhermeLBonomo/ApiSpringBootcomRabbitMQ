package com.spring.rabbitmq.demo_backend.api;

import com.spring.rabbitmq.demo_backend.dto.PagamentoDTO;
import com.spring.rabbitmq.demo_backend.facade.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoApi {
    @Autowired private PagamentoFacade pagamentoFacade;
    @PostMapping String processar(@RequestBody PagamentoDTO request) {
        return pagamentoFacade.solicitarPagamento(request);
    }
}
