package com.ds.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemCreateDto {
    private Double quantity;
    private String code;
}
