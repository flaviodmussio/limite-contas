package org.limite.contas.application.core.service;

import org.limite.contas.application.ports.out.BuscarSaldoPort;
import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.limite.contas.application.core.domain.Saldo;
import org.limite.contas.application.ports.in.SalvarSaldoServicePort;
import org.limite.contas.application.ports.out.SalvarSaldoPort;

import java.math.BigDecimal;
import java.util.Optional;

public class SalvarSaldoService implements SalvarSaldoServicePort {

    private final SalvarSaldoPort salvarSaldoPort;

    private final BuscarSaldoPort buscarSaldoPort;


    public SalvarSaldoService(SalvarSaldoPort salvarSaldoPort, BuscarSaldoPort buscarSaldoPort) {
        this.salvarSaldoPort = salvarSaldoPort;
        this.buscarSaldoPort = buscarSaldoPort;
    }

    @Override
    public Saldo salvarSaldo(Saldo saldo) {

        SaldoEntity saldoBusca = buscarSaldoPort.buscarSaldo(saldo.getContaId());
        saldo.setSaldo(saldo.getValorMovimento().add(Optional.ofNullable(saldoBusca.getSaldo()).orElse(new BigDecimal(0.00))));
        Saldo saldoSalvo = salvarSaldoPort.salvarSaldo(saldo);
        return saldoSalvo;
    }

}