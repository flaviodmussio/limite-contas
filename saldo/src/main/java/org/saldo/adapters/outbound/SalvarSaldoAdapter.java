package org.saldo.adapters.outbound;

import lombok.AllArgsConstructor;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.adapters.inbound.mapper.SaldoToSaldoEntityMapper;
import org.saldo.adapters.outbound.publish.LimitePublisher;
import org.saldo.adapters.outbound.repository.SaldoRepository;
import org.saldo.application.core.domain.Saldo;
import org.saldo.application.ports.out.SalvarSaldoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class SalvarSaldoAdapter implements SalvarSaldoPort {

    private final SaldoRepository saldoRepository;

    private final SaldoToSaldoEntityMapper saldoToSaldoEntityMapper;

    @Autowired
    private LimitePublisher limitePublisher;

    @Override
    @Transactional
    public Saldo salvarSaldo(Saldo saldo) {
        SaldoEntity saldoEntity = saldoToSaldoEntityMapper.mapper(saldo);
        saldoRepository.saveAndFlush(saldoEntity);
        if (saldo.getSaldo().compareTo(BigDecimal.ZERO) < 0){
            limitePublisher.publishLimiteEvent(saldo);
        }
        return saldo;
    }
}
