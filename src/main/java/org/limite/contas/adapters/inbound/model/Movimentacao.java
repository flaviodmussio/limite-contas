package org.limite.contas.adapters.inbound.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Movimentacao {

    private String agencia;

    private String numeroConta;

    private String digitoConta;

    private BigDecimal valorMovimento;

}
