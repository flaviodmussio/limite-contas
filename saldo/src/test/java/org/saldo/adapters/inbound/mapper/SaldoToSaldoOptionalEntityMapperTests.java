package org.saldo.adapters.inbound.mapper;

import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.adapters.outbound.BuscarSaldoAdapter;
import org.saldo.adapters.outbound.SalvarSaldoAdapter;
import org.saldo.adapters.outbound.repository.SaldoRepository;
import org.saldo.application.core.domain.Saldo;
import org.saldo.application.core.service.SalvarSaldoService;
import org.springframework.beans.BeanUtils;

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