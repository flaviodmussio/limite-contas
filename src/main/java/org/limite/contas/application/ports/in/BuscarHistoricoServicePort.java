package org.limite.contas.application.ports.in;

import org.limite.contas.adapters.inbound.entity.HistoricoNegativoEntity;

import java.util.List;

public interface BuscarHistoricoServicePort {

    List<HistoricoNegativoEntity> buscarHistorico(Long id_conta);

}
