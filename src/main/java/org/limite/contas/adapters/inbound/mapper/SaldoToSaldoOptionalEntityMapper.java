package org.limite.contas.adapters.inbound.mapper;

import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SaldoToSaldoOptionalEntityMapper {

    public SaldoEntity mapper(Optional<SaldoEntity> saldo){
        var saldoEntity = new SaldoEntity();
        BeanUtils.copyProperties(saldo.isPresent()?saldo.get():new SaldoEntity(), saldoEntity);
        return saldoEntity;
    }
}
