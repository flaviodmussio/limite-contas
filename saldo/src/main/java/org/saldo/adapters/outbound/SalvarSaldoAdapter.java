package org.saldo.adapters.outbound;

import lombok.AllArgsConstructor;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.adapters.inbound.mapper.SaldoToSaldoEntityMapper;
import org.saldo.adapters.outbound.repository.SaldoRepository;
import org.saldo.application.core.domain.Saldo;
import org.saldo.application.ports.out.SalvarSaldoPort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class SalvarSaldoAdapter implements SalvarSaldoPort {

    private final SaldoRepository saldoRepository;

    private final SaldoToSaldoEntityMapper saldoToSaldoEntityMapper;

    @Override
    @Transactional
    public Saldo salvarSaldo(Saldo saldo) {
        SaldoEntity saldos = new SaldoEntity();
        SaldoEntity saldoEntity = saldoToSaldoEntityMapper.mapper(saldo);
        saldos.setAgencia(saldoEntity.getAgencia());
        saldos.setSaldo(saldoEntity.getSaldo());
        saldos.setDigito_conta(saldoEntity.getDigito_conta());
        saldos.setNumero_conta(saldoEntity.getNumero_conta());
        saldos.setId_conta(saldoEntity.getId_conta());
        saldos.setValor_movimento(saldoEntity.getValor_movimento());
        return saldoToSaldoEntityMapper.mapper(saldoRepository.save(saldos));
    }

}
