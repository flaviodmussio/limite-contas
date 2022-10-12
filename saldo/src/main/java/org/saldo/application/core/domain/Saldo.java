package org.saldo.application.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class Saldo implements Serializable {

    private Long contaId;

    private String agencia;

    private String numeroConta;

    private String digitoConta;

    private BigDecimal valorMovimento;

    private BigDecimal saldo;
}
