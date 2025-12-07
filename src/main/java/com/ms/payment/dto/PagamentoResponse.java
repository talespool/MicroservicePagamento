package com.ms.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoResponse {
    private Long id;
    private BigDecimal valor;
    private String clienteId;
    private String status;
    private String metodoPagamento;
    private LocalDateTime dataCriacao;

    public PagamentoResponse() {}

    public PagamentoResponse(Long id, BigDecimal valor, String clienteId, String status, String metodoPagamento,
            LocalDateTime dataCriacao) {
        this.id = id;
        this.valor = valor;
        this.clienteId = clienteId;
        this.status = status;
        this.metodoPagamento = metodoPagamento;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    
}
