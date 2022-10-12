package org.saldo.adapters.inbound;

import lombok.AllArgsConstructor;
import org.saldo.adapters.inbound.mapper.HistoricoEntityToHistoricoResponseMapper;
import org.saldo.adapters.inbound.mapper.SaldoEntityToSaldoResponseMapper;
import org.saldo.adapters.inbound.response.HistoricoNegativoResponse;
import org.saldo.adapters.inbound.response.SaldoResponse;
import org.saldo.application.ports.in.BuscarHistoricoServicePort;
import org.saldo.application.ports.in.BuscarSaldoServicePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/contas/{id_conta}/historicos")
@AllArgsConstructor
public class HistoricoController {
    private final BuscarHistoricoServicePort buscarHistoricoServicePort;

    private final HistoricoEntityToHistoricoResponseMapper historicoEntityToHistoricoResponseMapper;


    @GetMapping
    public List<HistoricoNegativoResponse> consultarSaldo(@PathVariable Long id_conta){
        return historicoEntityToHistoricoResponseMapper.mapper(buscarHistoricoServicePort.buscarHistorico(id_conta));
    }
}
