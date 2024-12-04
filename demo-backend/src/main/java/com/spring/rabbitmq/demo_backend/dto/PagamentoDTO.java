package com.spring.rabbitmq.demo_backend.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class PagamentoDTO {
    private String numeroPedido;
    private BigDecimal valor;
    private String produto;

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(final String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(final String produto) {
        this.produto = produto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PagamentoDTO{" +
                "numeroPedido='" + numeroPedido + '\'' +
                ", valor=" + valor +
                ", produto='" + produto + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final PagamentoDTO that = (PagamentoDTO) o;
        return Objects.equals(numeroPedido, that.numeroPedido) && Objects.equals(valor, that.valor) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroPedido, valor, produto);
    }
}
