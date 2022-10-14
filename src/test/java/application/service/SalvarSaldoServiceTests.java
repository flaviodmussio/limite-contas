package application.service;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.limite.contas.adapters.inbound.mapper.SaldoToSaldoEntityMapper;
import org.limite.contas.adapters.inbound.mapper.SaldoToSaldoOptionalEntityMapper;
import org.limite.contas.adapters.outbound.BuscarSaldoAdapter;
import org.limite.contas.adapters.outbound.SalvarSaldoAdapter;
import org.limite.contas.adapters.outbound.repository.SaldoRepository;
import org.limite.contas.application.core.domain.Saldo;
import org.limite.contas.application.core.service.SalvarSaldoService;

public class SalvarSaldoServiceTests {
    @Mock
    private SalvarSaldoService salvarSaldoService;

    @Mock
    private SalvarSaldoAdapter salvarSaldoAdapter;

    @Mock
    private SaldoEntity saldoEntity;

    @Mock
    private SaldoRepository saldoRepository;

    @Mock
    private Saldo saldo;

    @Mock
    private SaldoToSaldoEntityMapper saldoToSaldoEntityMapper;

    @Mock
    private SaldoToSaldoOptionalEntityMapper saldoToSaldoOptionalEntityMapper;
    @Mock
    private BuscarSaldoAdapter buscarSaldoAdapter;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        Objetos objetos = new Objetos();
        this.saldo = objetos.getSaldo();
        saldoToSaldoEntityMapper.mapper(saldo);
        this.saldoEntity = objetos.getSaldoEntity();
        this.buscarSaldoAdapter = new BuscarSaldoAdapter(saldoRepository, saldoToSaldoOptionalEntityMapper);
        this.salvarSaldoService = new SalvarSaldoService(salvarSaldoAdapter,buscarSaldoAdapter);

    }

    @Test
    public void salvarSaldo() {
        this.buscarSaldoAdapter.buscarSaldo(this.saldo.getContaId());
        Mockito.when(buscarSaldoAdapter.buscarSaldo(this.saldo.getContaId())).thenReturn(this.saldoEntity);
        this.salvarSaldoService.salvarSaldo(this.saldo);
    }
}
