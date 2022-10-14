package org.limite.contas.adapters.inbound;

import lombok.AllArgsConstructor;
import org.limite.contas.adapters.inbound.mapper.SaldoEntityToSaldoResponseMapper;
import org.limite.contas.adapters.inbound.response.SaldoResponse;
import org.limite.contas.application.ports.in.BuscarSaldoServicePort;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/api/contas/{id_conta}/saldos")
@AllArgsConstructor
public class SaldoController {

    private final BuscarSaldoServicePort buscarSaldoServicePort;

    private final SaldoEntityToSaldoResponseMapper saldoEntityToSaldoResponseMapper;


    @GetMapping
    public SaldoResponse consultarSaldo(@PathVariable Long id_conta){
        return saldoEntityToSaldoResponseMapper.mapper(buscarSaldoServicePort.buscarSaldo(id_conta));
    }

}
