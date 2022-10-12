package org.saldo.application.ports.out;

import org.saldo.adapters.inbound.entity.HistoricoNegativoEntity;

import java.util.List;

public interface BuscarHistoricoPort {

    List<HistoricoNegativoEntity> buscarHistorico(Long contaId);

}
