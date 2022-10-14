package org.limite.contas.adapters.inbound.mapper;

import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.limite.contas.application.core.domain.Saldo;
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
