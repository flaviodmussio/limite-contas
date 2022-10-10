package org.saldo.application.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class Saldo implements Serializable {

    private Long id_conta;

    private String agencia;

    private String numero_conta;

    private String digito_conta;

    private BigDecimal valor_movimento;

    private BigDecimal saldo;
}
