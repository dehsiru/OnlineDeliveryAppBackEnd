package com.ds.order.external;

import com.ds.order.dto.Currency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.security.PublicKey;

@Component
@AllArgsConstructor
public class CurrencyExternal {

    private final RestTemplate restTemplate;

    public Currency getCurrentCurrency(){
        return this.restTemplate.getForEntity("https://api.exchangeratesapi.io/latest",Currency.class).getBody();
    }
}
