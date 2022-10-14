package org.limite.contas.adapters.inbound.mapper;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.limite.contas.application.core.domain.Saldo;

public class SaldoToSaldoEntityMapperTests {
    @InjectMocks
    private SaldoToSaldoEntityMapper saldoToSaldoEntityMapper;

    @Mock
    private Saldo saldo;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        Objetos objetos = new Objetos();
        this.saldo = objetos.getSaldo();

    }

    @Test
    public void mapper() {
        this.saldoToSaldoEntityMapper.mapper(this.saldo);
    }
}