package org.limite.contas.application.ports.out;

import org.limite.contas.application.core.domain.Saldo;

public interface SalvarSaldoPort {

    Saldo salvarSaldo(Saldo saldo);

}
