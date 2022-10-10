package org.saldo.application.ports.out;

import org.saldo.application.core.domain.Saldo;

public interface BuscarSaldoPort {

    Saldo buscarSaldo(Long id_conta);
}
