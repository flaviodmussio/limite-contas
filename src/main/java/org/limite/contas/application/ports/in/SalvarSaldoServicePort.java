package org.limite.contas.application.ports.in;

import org.limite.contas.application.core.domain.Saldo;

public interface SalvarSaldoServicePort {

    Saldo salvarSaldo(Saldo saldo);
}
