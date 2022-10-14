package org.saldo.adapters.outbound;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.saldo.adapters.inbound.entity.HistoricoNegativoEntity;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.adapters.inbound.mapper.SaldoToHistoricoMapper;
import org.saldo.adapters.inbound.mapper.SaldoToSaldoEntityMapper;
import org.saldo.adapters.outbound.publish.LimitePublisher;
import org.saldo.adapters.outbound.repository.HistoricoNegativoRepository;
import org.saldo.adapters.outbound.repository.SaldoRepository;
import org.saldo.application.core.domain.Saldo;

import java.math.BigDecimal;

public class SalvarSaldoAdapterTests {
    @InjectMocks
    private SalvarSaldoAdapter salvarSaldoAdapter;

    @Mock
    private SaldoEntity saldoEntity;

    @Mock
    private Saldo saldo;

    @Mock
    private SaldoToSaldoEntityMapper saldoToSaldoEntityMapper;

    @Mock
    private SaldoToHistoricoMapper saldoToHistoricoMapper;

    @Mock
    private HistoricoNegativoEntity historicoNegativoEntity;

    @Mock
    private SaldoRepository saldoRepository;

    @Mock
    private LimitePublisher limitePublisher;

    @Mock
    private HistoricoNegativoRepository historicoNegativoRepository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        Objetos objetos = new Objetos();
        this.saldo = objetos.getSaldo();
        saldoToSaldoEntityMapper.mapper(saldo);
        this.saldoEntity = objetos.getSaldoEntity();
        this.saldoToHistoricoMapper.mapper(saldoEntity);
        this.historicoNegativoEntity = objetos.getHistoricoNegativoEntity();

    }

    @Test
    public void salvarSaldoMaiorQueZero() {
        Mockito.when(this.saldoToSaldoEntityMapper.mapper(this.saldo)).thenReturn(this.saldoEntity);
        Mockito.when(this.saldoToHistoricoMapper.mapper(this.saldoEntity)).thenReturn(this.historicoNegativoEntity);
        saldoRepository.saveAndFlush(this.saldoEntity);
        this.salvarSaldoAdapter.salvarSaldo(this.saldo);
    }

    @Test
    public void salvarSaldoMenorQueZero() {
        Mockito.when(this.saldoToSaldoEntityMapper.mapper(this.saldo)).thenReturn(this.saldoEntity);
        this.saldo.setSaldo(BigDecimal.valueOf(-30.00));
        Mockito.when(this.saldoToHistoricoMapper.mapper(this.saldoEntity)).thenReturn(this.historicoNegativoEntity);
        saldoRepository.saveAndFlush(this.saldoEntity);
        this.salvarSaldoAdapter.salvarSaldo(this.saldo);
    }
}