package org.limite.contas.adapters.inbound.mapper;

import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.limite.contas.adapters.inbound.response.SaldoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SaldoEntityToSaldoResponseMapper {
    public SaldoResponse mapper(SaldoEntity saldo){
        var saldoResponse = new SaldoResponse();
        BeanUtils.copyProperties(saldo, saldoResponse);
        return saldoResponse;
    }
}
