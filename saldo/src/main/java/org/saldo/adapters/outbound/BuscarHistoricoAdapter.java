package org.saldo.adapters.outbound;

import lombok.AllArgsConstructor;
import org.saldo.adapters.inbound.entity.HistoricoNegativoEntity;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.adapters.inbound.mapper.SaldoToSaldoOptionalEntityMapper;
import org.saldo.adapters.outbound.repository.HistoricoNegativoRepository;
import org.saldo.adapters.outbound.repository.SaldoRepository;
import org.saldo.application.ports.out.BuscarHistoricoPort;
import org.saldo.application.ports.out.BuscarSaldoPort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class BuscarHistoricoAdapter implements BuscarHistoricoPort {

    private final HistoricoNegativoRepository historicoNegativoRepository;


    @Override
    @Transactional
    public List<HistoricoNegativoEntity> buscarHistorico(Long contaId) {
        return historicoNegativoRepository.findByContaId(contaId);
    }
}

