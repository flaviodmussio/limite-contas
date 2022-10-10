package org.saldo.application.ports.in;

import org.saldo.adapters.inbound.model.Movimentacao;
import org.saldo.application.core.domain.Saldo;

public interface SalvarSaldoServicePort {

    Saldo salvarSaldo(Saldo saldo);
}
