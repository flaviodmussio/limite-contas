package org.limite.contas.adapters.inbound.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class HistoricoNegativoResponse {
    private Long id;

    private Long contaId;

    private BigDecimal valorMovimento;

    private BigDecimal saldo;

    private Date dataHoraInsercao;
}