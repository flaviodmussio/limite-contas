package org.limite.contas.adapters.inbound.mapper;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.limite.contas.adapters.inbound.entity.SaldoEntity;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class SaldoToSaldoOptionalEntityMapperTests {
    @InjectMocks
    private SaldoToSaldoOptionalEntityMapper saldoToSaldoOptionalEntityMapper;

    @Mock
    private SaldoEntity saldoEntity;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        Objetos objetos = new Objetos();
        this.saldoEntity = objetos.getSaldoEntity();

    }

    @Test
    public void mapper() {
        this.saldoToSaldoOptionalEntityMapper.mapper(Optional.ofNullable(this.saldoEntity));
    }
}