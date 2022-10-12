package org.saldo.adapters.inbound;

import lombok.AllArgsConstructor;
import org.saldo.adapters.inbound.mapper.SaldoEntityToSaldoResponseMapper;
import org.saldo.adapters.inbound.response.SaldoResponse;
import org.saldo.application.ports.in.BuscarSaldoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
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
