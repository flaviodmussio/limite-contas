package org.saldo.adapters.inbound.mapper;

import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.adapters.inbound.response.SaldoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SaldoEntityToSaldoResponseMapper {
    public SaldoResponse mapper(SaldoEntity saldo){
        var saldoResponse = new SaldoResponse();
        BeanUtils.copyProperties(saldo, saldoResponse);
        return saldoResponse;
    }
}
