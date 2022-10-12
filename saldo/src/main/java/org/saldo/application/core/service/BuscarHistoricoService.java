package org.saldo.application.core.service;

import org.saldo.adapters.inbound.entity.HistoricoNegativoEntity;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.application.ports.in.BuscarHistoricoServicePort;
import org.saldo.application.ports.out.BuscarHistoricoPort;
import org.saldo.application.ports.out.BuscarSaldoPort;

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