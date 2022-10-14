package org.saldo.adapters.inbound.mapper;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.application.core.domain.Saldo;

import java.util.Optional;

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