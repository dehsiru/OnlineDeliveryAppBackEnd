package com.ds.order.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
public class Order {

    @Id
    private String id;

    private List<OrderItem> items = new ArrayList<>();

    private CurrencyEnum currency = CurrencyEnum.EURO;

    private Double totalPriceEuro;

    private Double totalPriceCurrency;
}
