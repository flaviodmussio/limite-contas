package application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.saldo.adapters.outbound.BuscarHistoricoAdapter;
import org.saldo.application.core.service.BuscarHistoricoService;

public class BuscarHistoricoServiceTests {

    @Mock
    private BuscarHistoricoService buscarHistoricoService;

    @Mock
    private BuscarHistoricoAdapter buscarHistoricoAdapter;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.buscarHistoricoService = new BuscarHistoricoService(buscarHistoricoAdapter);

    }

    @Test
    public void buscarHistorico() {
        buscarHistoricoService.buscarHistorico(000111112L);
    }
}
