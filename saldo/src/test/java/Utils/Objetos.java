package Utils;

import org.saldo.adapters.inbound.entity.HistoricoNegativoEntity;
import org.saldo.adapters.inbound.entity.SaldoEntity;
import org.saldo.adapters.inbound.mapper.SaldoToHistoricoMapper;
import org.saldo.application.core.domain.Saldo;

import java.math.BigDecimal;
import java.util.Date;

public class Objetos {

    public Saldo getSaldo() {
        Saldo saldo = new Saldo();
        saldo.setContaId(000111112L);
        saldo.setAgencia("000");
        saldo.setNumeroConta("11111");
        saldo.setDigitoConta("2");
        saldo.setValorMovimento(BigDecimal.valueOf(100.2));
        saldo.setSaldo(BigDecimal.valueOf(100.2));
        return saldo;
    }

    public SaldoEntity getSaldoEntity() {
        SaldoEntity saldo = new SaldoEntity();
        saldo.setContaId(000111112L);
        saldo.setAgencia("000");
        saldo.setNumeroConta("11111");
        saldo.setDigitoConta("2");
        saldo.setValorMovimento(BigDecimal.valueOf(100.2));
        saldo.setSaldo(BigDecimal.valueOf(100.2));
        return saldo;
    }

    public HistoricoNegativoEntity getHistoricoNegativoEntity() {
        SaldoToHistoricoMapper saldoToHistoricoMapper = new SaldoToHistoricoMapper();
        HistoricoNegativoEntity historicoNegativoEntity = new HistoricoNegativoEntity();
        historicoNegativoEntity = saldoToHistoricoMapper.mapper(getSaldoEntity());
        historicoNegativoEntity.setId(100L);
        historicoNegativoEntity.setDataHoraInsercao(new Date());
        return historicoNegativoEntity;
    }
}
