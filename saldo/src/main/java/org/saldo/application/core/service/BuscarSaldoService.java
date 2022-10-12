package org.saldo.application.core.service;

import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.application.core.domain.Saldo;
import org.saldo.application.ports.in.BuscarSaldoServicePort;
import org.saldo.application.ports.out.BuscarSaldoPort;

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
