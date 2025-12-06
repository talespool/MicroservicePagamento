package com.ms.payment.service;

import com.ms.payment.dto.CriarPagamentoRequest;
import com.ms.payment.dto.PagamentoResponse;
import com.ms.payment.dto.AtualizarPagamentoRequest;
import com.ms.payment.mapper.PagamentoMapper;
import com.ms.payment.model.Pagamento;
import com.ms.payment.model.StatusPagamento;
import com.ms.payment.repository.PagamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

	private final PagamentoRepository pagamentoRepository;
	private final PagamentoMapper pagamentoMapper;

	public PagamentoService(PagamentoRepository pagamentoRepository, PagamentoMapper pagamentoMapper) {
		this.pagamentoRepository = pagamentoRepository;
		this.pagamentoMapper = pagamentoMapper;
	}

	@Transactional
	public PagamentoResponse criarPagamento(CriarPagamentoRequest request) {
		Pagamento pagamento = pagamentoMapper.toEntity(request);
		pagamento.setStatus(StatusPagamento.PROCESSANDO);
		pagamento.setDataCriacao(LocalDateTime.now());
		Pagamento salvo = pagamentoRepository.save(pagamento);
		return pagamentoMapper.toResponse(salvo);
	}

	public PagamentoResponse buscarPagamentoPorId(Long id) {
		Pagamento pagamento = pagamentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
		return pagamentoMapper.toResponse(pagamento);
	}

	public List<PagamentoResponse> listarPagamentos() {
		return pagamentoRepository.findAll().stream()
				.map(pagamentoMapper::toResponse)
				.collect(Collectors.toList());
	}

	@Transactional
	public PagamentoResponse atualizarStatus(Long id, AtualizarPagamentoRequest request) {
		Pagamento pagamento = pagamentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
		pagamento.setStatus(StatusPagamento.valueOf(request.getStatus().toUpperCase()));
		Pagamento atualizado = pagamentoRepository.save(pagamento);
		return pagamentoMapper.toResponse(atualizado);
	}
}
