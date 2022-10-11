package org.saldo.application.ports.out;

import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.application.core.domain.Saldo;

public interface BuscarSaldoPort {

    SaldoEntity buscarSaldo(Long id_conta);
}
