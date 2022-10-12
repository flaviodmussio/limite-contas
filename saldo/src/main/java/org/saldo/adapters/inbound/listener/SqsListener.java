package org.saldo.adapters.inbound.listener;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import lombok.AllArgsConstructor;
import org.saldo.adapters.inbound.mapper.SaldoSqsToSaldoMapper;
import org.saldo.application.core.domain.Saldo;
import org.saldo.application.ports.in.SalvarSaldoServicePort;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SqsListener {

    private final SalvarSaldoServicePort salvarSaldoServicePort;

        private final SaldoSqsToSaldoMapper saldoRequestToSaldoMapper;


    @io.awspring.cloud.messaging.listener.annotation.SqsListener(value = "${cloud.aws.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(@Payload String movimentacao) {
        Saldo saldo = saldoRequestToSaldoMapper.mapper(movimentacao);
        salvarSaldoServicePort.salvarSaldo(saldo);

    }
}