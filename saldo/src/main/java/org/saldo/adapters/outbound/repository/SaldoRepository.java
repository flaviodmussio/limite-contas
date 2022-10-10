package org.saldo.adapters.outbound.repository;

import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository<SaldoEntity, Long> {
}
