package org.limite.contas.adapters.inbound.mapper;

import org.limite.contas.adapters.inbound.entity.HistoricoNegativoEntity;
import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SaldoToHistoricoMapper {

    public HistoricoNegativoEntity mapper(SaldoEntity saldo){
        HistoricoNegativoEntity historicoNegativo = new HistoricoNegativoEntity();
        BeanUtils.copyProperties(saldo, historicoNegativo);
        return historicoNegativo;
    }
}
