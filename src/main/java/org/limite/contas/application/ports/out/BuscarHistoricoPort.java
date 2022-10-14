package org.limite.contas.application.ports.out;

import org.limite.contas.adapters.inbound.entity.HistoricoNegativoEntity;

import java.util.List;

public interface BuscarHistoricoPort {

    List<HistoricoNegativoEntity> buscarHistorico(Long contaId);

}
