package org.saldo.adapters.inbound.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class HistoricoNegativoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_conta", nullable = false)
    private Long id_conta;

    @Column(name = "valor_movimento", nullable = false)
    private BigDecimal valor_movimento;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    @Column(name = "data_hora_insercao", nullable = false)
    @CreationTimestamp
    private Date data_hora_insercao;
}