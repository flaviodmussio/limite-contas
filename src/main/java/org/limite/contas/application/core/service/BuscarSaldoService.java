package org.limite.contas.application.core.service;

import org.limite.contas.application.ports.out.BuscarSaldoPort;
import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.limite.contas.application.ports.in.BuscarSaldoServicePort;

public class BuscarSaldoService implements BuscarSaldoServicePort {

    private final BuscarSaldoPort buscarSaldoPort;


    public BuscarSaldoService(BuscarSaldoPort buscarSaldoPort) {
        this.buscarSaldoPort = buscarSaldoPort;
    }

    @Override
    public SaldoEntity buscarSaldo(Long contaId) {

        SaldoEntity saldoBusca = buscarSaldoPort.buscarSaldo(contaId);

        return saldoBusca;
    }
}
