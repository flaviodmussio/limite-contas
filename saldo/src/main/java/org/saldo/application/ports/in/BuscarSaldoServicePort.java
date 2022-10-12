package org.saldo.application.ports.in;

import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.application.core.domain.Saldo;

public interface BuscarSaldoServicePort {

    SaldoEntity buscarSaldo(Long id_conta);

}
