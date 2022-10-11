package org.saldo.adapters.outbound;

import lombok.AllArgsConstructor;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.adapters.inbound.mapper.SaldoToSaldoEntityMapper;
import org.saldo.adapters.inbound.mapper.SaldoToSaldoOptionalEntityMapper;
import org.saldo.adapters.outbound.repository.SaldoRepository;
import org.saldo.application.core.domain.Saldo;
import org.saldo.application.ports.out.BuscarSaldoPort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Component
@AllArgsConstructor
public class BuscarSaldoAdapter implements BuscarSaldoPort {

    private final SaldoRepository saldoRepository;

    private final SaldoToSaldoOptionalEntityMapper saldoToSaldoOptionalEntityMapper;

    @Override
    @Transactional
    public SaldoEntity buscarSaldo(Long id_conta) {
        return saldoToSaldoOptionalEntityMapper.mapper(saldoRepository.findById(id_conta));
    }
}
