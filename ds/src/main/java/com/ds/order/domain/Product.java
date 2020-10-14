package com.ds.order.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
public class Product {

    private String code;
    private String description;
    private Double price;

    @Transient
    private Double priceCurrency;



}
