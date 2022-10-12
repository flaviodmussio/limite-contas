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

    @Column(name = "contaId", nullable = false)
    private Long contaId;

    @Column(name = "valorMovimento", nullable = false)
    private BigDecimal valorMovimento;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    @Column(name = "dataHoraInsercao", nullable = false)
    @CreationTimestamp
    private Date dataHoraInsercao;
}