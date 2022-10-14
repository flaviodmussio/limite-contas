package org.limite.contas.adapters.outbound;

import lombok.AllArgsConstructor;
import org.limite.contas.adapters.inbound.mapper.SaldoToSaldoOptionalEntityMapper;
import org.limite.contas.adapters.outbound.repository.SaldoRepository;
import org.limite.contas.application.ports.out.BuscarSaldoPort;
import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class BuscarSaldoAdapter implements BuscarSaldoPort {

    private final SaldoRepository saldoRepository;

    private final SaldoToSaldoOptionalEntityMapper saldoToSaldoOptionalEntityMapper;

    @Override
    @Transactional
    public SaldoEntity buscarSaldo(Long contaId) {
        return saldoToSaldoOptionalEntityMapper.mapper(saldoRepository.findById(contaId));
    }
}
