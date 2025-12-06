package com.ms.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.payment.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
