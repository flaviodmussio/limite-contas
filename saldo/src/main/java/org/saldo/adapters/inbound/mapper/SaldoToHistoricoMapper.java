package org.saldo.adapters.inbound.mapper;

import org.joda.time.DateTime;
import org.saldo.adapters.inbound.entity.HistoricoNegativoEntity;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SaldoToHistoricoMapper {

    public HistoricoNegativoEntity mapper(SaldoEntity saldo){
        HistoricoNegativoEntity historicoNegativo = new HistoricoNegativoEntity();
        BeanUtils.copyProperties(saldo, historicoNegativo);
        return historicoNegativo;
    }
}
