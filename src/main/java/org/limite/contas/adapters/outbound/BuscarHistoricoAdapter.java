package org.limite.contas.adapters.outbound;

import lombok.AllArgsConstructor;
import org.limite.contas.adapters.inbound.entity.HistoricoNegativoEntity;
import org.limite.contas.adapters.outbound.repository.HistoricoNegativoRepository;
import org.limite.contas.application.ports.out.BuscarHistoricoPort;
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

