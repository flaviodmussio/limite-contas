package org.limite.contas.adapters.inbound.mapper;

import org.limite.contas.adapters.inbound.entity.HistoricoNegativoEntity;
import org.limite.contas.adapters.inbound.response.HistoricoNegativoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoricoEntityToHistoricoResponseMapper {

    public List<HistoricoNegativoResponse> mapper(List<HistoricoNegativoEntity> historicoNegativo){
        List<HistoricoNegativoResponse> historicoNegativoResponses = new ArrayList<>();
        historicoNegativo.forEach(historico -> {
            HistoricoNegativoResponse historicoNegativoResponse = new HistoricoNegativoResponse();
            BeanUtils.copyProperties(historico, historicoNegativoResponse);
            historicoNegativoResponses.add(historicoNegativoResponse);
        });
        return historicoNegativoResponses;
    }
}
