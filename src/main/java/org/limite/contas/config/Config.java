package org.limite.contas.config;

import org.limite.contas.adapters.outbound.BuscarSaldoAdapter;
import org.limite.contas.application.core.service.BuscarHistoricoService;
import org.limite.contas.application.core.service.BuscarSaldoService;
import org.limite.contas.application.core.service.SalvarSaldoService;
import org.limite.contas.adapters.outbound.BuscarHistoricoAdapter;
import org.limite.contas.adapters.outbound.SalvarSaldoAdapter;
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
