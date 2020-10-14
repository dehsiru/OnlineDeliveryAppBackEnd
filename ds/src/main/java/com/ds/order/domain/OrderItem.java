package com.ds.order.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {

    private Product product;

    private Double quantity;

    private Double totalPriceEuro;

}
