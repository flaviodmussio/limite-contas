package org.saldo.adapters.inbound.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Movimentacao {

    private String agencia;

    private String numero_conta;

    private String digito_conta;

    private BigDecimal valor_movimento;

}
