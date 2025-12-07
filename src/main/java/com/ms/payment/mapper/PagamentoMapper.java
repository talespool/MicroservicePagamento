package com.ms.payment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.ms.payment.dto.CriarPagamentoRequest;
import com.ms.payment.dto.PagamentoResponse;
import com.ms.payment.model.MetodoPagamento;
import com.ms.payment.model.Pagamento;
import com.ms.payment.model.StatusPagamento;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(source = "metodoPagamento", target = "metodoPagamento")
    @Mapping(source = "clienteId", target = "clienteId")
    Pagamento toEntity(CriarPagamentoRequest dto);

    @Mapping(source = "metodoPagamento", target = "metodoPagamento", qualifiedByName = "enumToString")
    @Mapping(source = "status", target = "status", qualifiedByName = "enumToString")
    @Mapping(source = "dataCriacao", target = "dataCriacao") 
    PagamentoResponse toResponse(Pagamento entity);

    @Named("enumToString")
    default String enumToString(Enum<?> enumValue) {
        return enumValue != null ? enumValue.name() : null;
    }
    
    default MetodoPagamento stringToMetodoPagamento(String stringValue) {
        if (stringValue == null) {
            return null;
        }
        return MetodoPagamento.valueOf(stringValue.toUpperCase());
    }
    
    default StatusPagamento stringToStatusTransacao(String stringValue) {
        if (stringValue == null) {
            return null;
        }
        return StatusPagamento.valueOf(stringValue.toUpperCase());
    }
}