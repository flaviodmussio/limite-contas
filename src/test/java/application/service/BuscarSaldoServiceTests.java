package application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.limite.contas.adapters.outbound.BuscarSaldoAdapter;
import org.limite.contas.application.core.service.BuscarSaldoService;

public class BuscarSaldoServiceTests {

    @Mock
    private BuscarSaldoService buscarSaldoService;

    @Mock
    private BuscarSaldoAdapter buscarSaldoAdapter;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.buscarSaldoService = new BuscarSaldoService(buscarSaldoAdapter);

    }

    @Test
    public void buscarSaldo() {
        buscarSaldoService.buscarSaldo(000111112L);
    }
}
