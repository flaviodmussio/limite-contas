package org.limite.contas.adapters.outbound;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.limite.contas.application.core.service.BuscarHistoricoService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.limite.contas.adapters.inbound.entity.HistoricoNegativoEntity;
import org.limite.contas.adapters.outbound.repository.HistoricoNegativoRepository;

import java.util.List;

public class BuscarHistoricoAdapterTests {

    @Mock
    private BuscarHistoricoService buscarHistoricoService;

    @Mock
    HistoricoNegativoEntity historicoNegativoEntity;

    @Mock
    List<HistoricoNegativoEntity> listHistoricoNegativoEntity;

    @InjectMocks
    private BuscarHistoricoAdapter buscarHistoricoAdapter;

    @Mock
    private HistoricoNegativoRepository historicoNegativoRepository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        Objetos objetos = new Objetos();
        this.historicoNegativoEntity = objetos.getHistoricoNegativoEntity();
        this.listHistoricoNegativoEntity.add(this.historicoNegativoEntity);
    }

    @Test
    public void buscarHistorico() {
        Mockito.when(this.historicoNegativoRepository.findByContaId(000111112L)).thenReturn(this.listHistoricoNegativoEntity);
        this.buscarHistoricoAdapter.buscarHistorico(000111112L);
    }
}
