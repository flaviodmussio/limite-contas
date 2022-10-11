package org.saldo.adapters.outbound.publish;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import com.google.gson.Gson;
import org.saldo.application.core.domain.Saldo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LimitePublisher {

    private AmazonSNS snsClient;
    private Topic limiteEventsTopic;

    public LimitePublisher(AmazonSNS snsClient,
                           @Qualifier("limiteEventsTopic") Topic limiteEventsTopic) {
        this.snsClient = snsClient;
        this.limiteEventsTopic = limiteEventsTopic;
    }

    public void publishLimiteEvent(Saldo saldo) {
        Gson gson = new Gson();
        snsClient.publish(
            limiteEventsTopic.getTopicArn(),
            gson.toJson(saldo));
    }
}
