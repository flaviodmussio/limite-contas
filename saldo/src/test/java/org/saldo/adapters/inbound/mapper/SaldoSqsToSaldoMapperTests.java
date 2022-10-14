package org.saldo.adapters.inbound.mapper;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.saldo.application.core.domain.Saldo;

public class SaldoSqsToSaldoMapperTests {
    @InjectMocks
    private SaldoSqsToSaldoMapper saldoSqsToSaldoMapper;

    private String saldo;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.saldo = "{\"agencia\":\"000\",\"numeroConta\":\"11111\",\"digitoConta\":\"2\",\"valorMovimento\":-100.20}";

    }

    @Test
    public void mapper() {
        this.saldoSqsToSaldoMapper.mapper(saldo);
    }
}