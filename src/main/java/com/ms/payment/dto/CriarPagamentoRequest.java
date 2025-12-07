package com.ms.payment.dto;

import java.math.BigDecimal;

public class CriarPagamentoRequest {
    private String clienteId;
    private BigDecimal valor;
    private String metodoPagamento;

    public CriarPagamentoRequest() {}

    public CriarPagamentoRequest(String clienteId, BigDecimal valor, String metodoPagamento) {
        this.clienteId = clienteId;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
