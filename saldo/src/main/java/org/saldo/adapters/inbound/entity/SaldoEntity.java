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
    @Column(name = "id_conta", nullable = false)
    private Long id_conta;

    @Column(name = "agencia", nullable = false)
    private String agencia;

    @Column(name = "numero_conta", nullable = false)
    private String numero_conta;

    @Column(name = "digito_conta", nullable = false)
    private String digito_conta;

    @Column(name = "valor_movimento", nullable = false)
    private BigDecimal valor_movimento;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;
}
