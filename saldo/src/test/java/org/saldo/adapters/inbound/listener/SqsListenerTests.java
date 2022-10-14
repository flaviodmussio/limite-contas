package org.saldo.adapters.inbound.listener;


import Utils.Objetos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.saldo.adapters.inbound.mapper.SaldoSqsToSaldoMapper;
import org.saldo.application.core.domain.Saldo;
import org.saldo.application.core.service.SalvarSaldoService;
import java.math.BigDecimal;

public class SqsListenerTests {

    @Mock
    private SqsListener sqsListener;
    @Mock
    private Saldo saldo;

    private String movimentacao;

    @Mock
    private SalvarSaldoService salvarSaldoService;

    @Mock
    private SaldoSqsToSaldoMapper saldoRequestToSaldoMapper;

    @BeforeEach
    public void beforeEach() {
        Objetos objetos = new Objetos();
        MockitoAnnotations.openMocks(this);
        this.movimentacao = "{\"agencia\":\"000\",\"numeroConta\":\"11111\",\"digitoConta\":\"2\",\"valorMovimento\":-100.20}";
        this.saldo = objetos.getSaldo();
        this.saldoRequestToSaldoMapper.mapper(movimentacao);
        this.salvarSaldoService.salvarSaldo(this.saldo);
        this.sqsListener = new SqsListener(salvarSaldoService,saldoRequestToSaldoMapper);

    }

    @Test
    public void salvarSaldo() {
        this.sqsListener.receiveMessage(movimentacao);
    }
}
