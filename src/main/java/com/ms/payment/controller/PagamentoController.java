package com.ms.payment.controller;

import com.ms.payment.dto.AtualizarPagamentoRequest;
import com.ms.payment.dto.CriarPagamentoRequest;
import com.ms.payment.dto.PagamentoResponse;
import com.ms.payment.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH})
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<PagamentoResponse> criarPagamento(@RequestBody CriarPagamentoRequest request) {
        PagamentoResponse response = pagamentoService.criarPagamento(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponse> buscarPagamentoPorId(@PathVariable Long id) {
        PagamentoResponse response = pagamentoService.buscarPagamentoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PagamentoResponse>> listarPagamentos() {
        List<PagamentoResponse> pagamentos = pagamentoService.listarPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PagamentoResponse> atualizarStatus(@PathVariable Long id, @RequestBody AtualizarPagamentoRequest request) {
        PagamentoResponse response = pagamentoService.atualizarStatus(id, request);
        return ResponseEntity.ok(response);
    }
}
