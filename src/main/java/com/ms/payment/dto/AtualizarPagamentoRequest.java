package com.ms.payment.dto;

public class AtualizarPagamentoRequest {
    private String status;

    public AtualizarPagamentoRequest() {}

    public AtualizarPagamentoRequest(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
