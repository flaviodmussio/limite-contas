package org.limite.contas.application.ports.in;

import org.limite.contas.adapters.inbound.entity.SaldoEntity;

public interface BuscarSaldoServicePort {

    SaldoEntity buscarSaldo(Long id_conta);

}
