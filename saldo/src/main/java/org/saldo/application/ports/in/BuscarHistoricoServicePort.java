package org.saldo.application.ports.in;

import org.saldo.adapters.inbound.entity.HistoricoNegativoEntity;
import org.saldo.adapters.inbound.entity.SaldoEntity;

import java.util.List;

public interface BuscarHistoricoServicePort {

    List<HistoricoNegativoEntity> buscarHistorico(Long id_conta);

}
