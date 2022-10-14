package org.saldo.adapters.inbound;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.saldo.adapters.inbound.entity.HistoricoNegativoEntity;
import org.saldo.adapters.inbound.mapper.HistoricoEntityToHistoricoResponseMapper;
import org.saldo.adapters.inbound.response.HistoricoNegativoResponse;
import org.saldo.adapters.outbound.BuscarHistoricoAdapter;
import org.saldo.application.core.service.BuscarHistoricoService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HistoricoControllerTests {

    @InjectMocks
    private HistoricoController historicoController;

    @Mock
    private  BuscarHistoricoService buscarHistoricoService;

    @Mock
    private BuscarHistoricoAdapter buscarHistoricoAdapter;

    @Mock
    List<HistoricoNegativoResponse>  historicoNegativoResponses;

    @Mock
    List<HistoricoNegativoEntity>  historicoNegativoEntity;

    @Mock
    private  HistoricoEntityToHistoricoResponseMapper historicoEntityToHistoricoResponseMapper;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        Objetos objetos = new Objetos();
        this.buscarHistoricoService = new BuscarHistoricoService(buscarHistoricoAdapter);
        this.historicoEntityToHistoricoResponseMapper = new HistoricoEntityToHistoricoResponseMapper();
        List<HistoricoNegativoEntity> listHistoricoNegativoEntity = new ArrayList<>();
        listHistoricoNegativoEntity.add(objetos.getHistoricoNegativoEntity());
        this.historicoEntityToHistoricoResponseMapper.mapper(listHistoricoNegativoEntity);

    }

    @Test
    public void buscarHistorico() {
        this.historicoController.consultarSaldo(000111112L);
    }
}
