package org.limite.contas.application.ports.out;

import org.limite.contas.adapters.inbound.entity.SaldoEntity;

public interface BuscarSaldoPort {

    SaldoEntity buscarSaldo(Long contaId);
}
