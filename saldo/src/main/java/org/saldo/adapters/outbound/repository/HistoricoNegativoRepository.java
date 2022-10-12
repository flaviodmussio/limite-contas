package org.saldo.adapters.outbound.repository;

import org.saldo.adapters.inbound.entity.HistoricoNegativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoricoNegativoRepository extends JpaRepository<HistoricoNegativoEntity, Long> {
    List<HistoricoNegativoEntity> findByContaId(Long contaId);
}
