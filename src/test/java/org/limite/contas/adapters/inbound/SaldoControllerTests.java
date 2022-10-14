package org.limite.contas.adapters.inbound;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.limite.contas.adapters.inbound.mapper.SaldoEntityToSaldoResponseMapper;
import org.limite.contas.adapters.outbound.BuscarSaldoAdapter;
import org.limite.contas.application.core.service.BuscarSaldoService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SaldoControllerTests {

    @InjectMocks
    private SaldoController saldoController;

    @Mock
    private BuscarSaldoService buscarSaldoService;

    @Mock
    private BuscarSaldoAdapter buscarSaldoAdapter;

    @Mock
    private SaldoEntityToSaldoResponseMapper saldoEntityToSaldoResponseMapper;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        Objetos objetos = new Objetos();
        this.buscarSaldoService = new BuscarSaldoService(buscarSaldoAdapter);
        this.saldoEntityToSaldoResponseMapper = new SaldoEntityToSaldoResponseMapper();
        this.saldoEntityToSaldoResponseMapper.mapper(objetos.getSaldoEntity());

    }

    @Test
    public void buscarSaldo() {
        this.saldoController.consultarSaldo(000111112L);
    }
}

