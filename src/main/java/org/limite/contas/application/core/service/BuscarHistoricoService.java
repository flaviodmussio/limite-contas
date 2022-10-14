package org.limite.contas.application.core.service;

import org.limite.contas.adapters.inbound.entity.HistoricoNegativoEntity;
import org.limite.contas.application.ports.in.BuscarHistoricoServicePort;
import org.limite.contas.application.ports.out.BuscarHistoricoPort;

import java.util.List;

public class BuscarHistoricoService implements BuscarHistoricoServicePort {

    private final BuscarHistoricoPort buscarHistoricoPort;

    public BuscarHistoricoService(BuscarHistoricoPort buscarHistoricoPort) {
        this.buscarHistoricoPort = buscarHistoricoPort;
    }

    @Override
    public List<HistoricoNegativoEntity> buscarHistorico(Long contaId) {

        List<HistoricoNegativoEntity> historicoBusca = buscarHistoricoPort.buscarHistorico(contaId);

        return historicoBusca;
    }
}