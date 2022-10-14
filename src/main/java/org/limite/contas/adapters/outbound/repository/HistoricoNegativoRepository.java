package org.limite.contas.adapters.outbound.repository;

import org.limite.contas.adapters.inbound.entity.HistoricoNegativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoNegativoRepository extends JpaRepository<HistoricoNegativoEntity, Long> {
    List<HistoricoNegativoEntity> findByContaId(Long contaId);
}
