package org.limite.contas.adapters.outbound.repository;

import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository<SaldoEntity, Long> {
}
