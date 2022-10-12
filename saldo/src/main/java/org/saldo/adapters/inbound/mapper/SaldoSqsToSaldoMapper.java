package org.saldo.adapters.inbound.mapper;

import com.google.gson.Gson;
import org.saldo.adapters.inbound.model.Movimentacao;
import org.saldo.application.core.domain.Saldo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SaldoSqsToSaldoMapper {

    public Saldo mapper(String saldoSqs){
        Gson g = new Gson();
        var saldo = new Saldo();
        BeanUtils.copyProperties(g.fromJson(saldoSqs,Movimentacao.class), saldo);
        saldo.setContaId(Long.parseLong(saldo.getAgencia().concat(saldo.getNumeroConta()).concat(saldo.getDigitoConta())));
        return saldo;
    }
}
