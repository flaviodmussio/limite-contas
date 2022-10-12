package org.saldo.config;

import org.saldo.adapters.outbound.BuscarHistoricoAdapter;
import org.saldo.adapters.outbound.BuscarSaldoAdapter;
import org.saldo.adapters.outbound.SalvarSaldoAdapter;
import org.saldo.application.core.service.BuscarHistoricoService;
import org.saldo.application.core.service.BuscarSaldoService;
import org.saldo.application.core.service.SalvarSaldoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SalvarSaldoService salvarSaldoService(SalvarSaldoAdapter salvarSaldoAdapter, BuscarSaldoAdapter buscarSaldoAdapter){
        return new SalvarSaldoService(salvarSaldoAdapter, buscarSaldoAdapter);
    }

    @Bean
    public BuscarSaldoService buscarSaldoService(BuscarSaldoAdapter buscarSaldoAdapter){
        return new BuscarSaldoService(buscarSaldoAdapter);
    }

    @Bean
    public BuscarHistoricoService buscarHistoricoService(BuscarHistoricoAdapter buscarHistoricoAdapter){
        return new BuscarHistoricoService(buscarHistoricoAdapter);
    }
}
