package com.ds.order.dto;

import com.ds.order.domain.CurrencyEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateOrderDto {


    private CurrencyEnum currency = CurrencyEnum.EURO;
    private List<OrderItemCreateDto> orderItems = new ArrayList<>();

}
