package com.ds.order.rest;

import com.ds.order.domain.CurrencyEnum;
import com.ds.order.domain.Order;
import com.ds.order.dto.CreateOrderDto;
import com.ds.order.dto.Currency;
import com.ds.order.external.CurrencyExternal;
import com.ds.order.service.OrderService;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderRest {

    private final OrderService orderService;
    private final CurrencyExternal currencyExternal;

    @PostMapping
    @ApiOperation(value = "Create an order")
    public Order createOrder(@RequestBody CreateOrderDto order) {
        return this.orderService.createOrder(order);
    }

    @GetMapping("admin")
    @ApiOperation(value = "View all the orders (EURO)")
    public List<Order> getOrders() {
        return this.orderService.getOrders();
    }

    @GetMapping("admin/{currency}")
    @ApiOperation(value = "View all the orders to other currencies (CAD,HKD,PHP,USD)")
    public List<Order> getOrders(@PathVariable CurrencyEnum currency) {
        Currency currentCurrency = this.currencyExternal.getCurrentCurrency();

        List<Order> ordersChangeCurrency = this.orderService.getOrders();

        switch (currency) {
            case USD:
                ordersChangeCurrency.forEach(order -> {
                    order.setTotalPriceCurrency(order.getTotalPriceEuro() * currentCurrency.getRates().getUSD());
                    order.setCurrency(currency);
                });
                break;
            case CAD:
                ordersChangeCurrency.forEach(order -> {
                    order.setTotalPriceCurrency(order.getTotalPriceEuro() * currentCurrency.getRates().getCAD());
                    order.setCurrency(currency);
                });
                break;
            case HKD:
                ordersChangeCurrency.forEach(order -> {
                    order.setTotalPriceCurrency(order.getTotalPriceEuro() * currentCurrency.getRates().getHKD());
                    order.setCurrency(currency);
                });
                break;
            case PHP:
                ordersChangeCurrency.forEach(order -> {
                    order.setTotalPriceCurrency(order.getTotalPriceEuro() * currentCurrency.getRates().getPHP());
                    order.setCurrency(currency);
                });
                break;




            default:
                break;
        }
        return ordersChangeCurrency;

    }
}
