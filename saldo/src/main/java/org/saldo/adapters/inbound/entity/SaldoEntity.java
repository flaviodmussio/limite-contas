package org.saldo.adapters.inbound.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.saldo.application.core.domain.Saldo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class SaldoEntity {
    @Id
    @Column(name = "contaId", nullable = false)
    private Long contaId;

    @Column(name = "agencia", nullable = false)
    private String agencia;

    @Column(name = "numeroConta", nullable = false)
    private String numeroConta;

    @Column(name = "digitoConta", nullable = false)
    private String digitoConta;

    @Column(name = "valorMovimento", nullable = false)
    private BigDecimal valorMovimento;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;
}
