package org.saldo.adapters.inbound.mapper;

import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.application.core.domain.Saldo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SaldoToSaldoEntityMapper {

    public SaldoEntity mapper(Saldo saldo){
        var saldoEntity = new SaldoEntity();
        BeanUtils.copyProperties(saldo, saldoEntity);
        return saldoEntity;
    }
}
