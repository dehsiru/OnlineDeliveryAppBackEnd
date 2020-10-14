package com.ds.order.service;

import com.ds.order.domain.CurrencyEnum;
import com.ds.order.domain.Order;
import com.ds.order.domain.OrderItem;
import com.ds.order.domain.Product;
import com.ds.order.dto.CreateOrderDto;
import com.ds.order.dto.Currency;
import com.ds.order.external.CurrencyExternal;
import com.ds.order.repository.CategoryRepository;
import com.ds.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final CurrencyExternal currencyExternal;

    public Order createOrder(CreateOrderDto order){
        Order orderC = toOrder(order);
        if(!order.getCurrency().equals(CurrencyEnum.EURO)  ){
            Currency currentCurrency = this.currencyExternal.getCurrentCurrency();
            switch (order.getCurrency()){
                case USD:
                    orderC.setTotalPriceCurrency(orderC.getTotalPriceEuro() * currentCurrency.getRates().getUSD());
                    break;
                case CAD:
                    orderC.setTotalPriceCurrency(orderC.getTotalPriceEuro() * currentCurrency.getRates().getCAD());
                    break;
                case HKD:
                    orderC.setTotalPriceCurrency(orderC.getTotalPriceEuro() * currentCurrency.getRates().getHKD());
                    break;
                case PHP:
                    orderC.setTotalPriceCurrency(orderC.getTotalPriceEuro() * currentCurrency.getRates().getPHP());
                    break;
                default:
                    break;
            }
        }

        return this.orderRepository.save(orderC);
    }

    public List<Order> getOrders(){
        return this.orderRepository.findAll();
    }

    public Order toOrder(CreateOrderDto orderDto){
        Order order = new Order();

        List<Product> products = this.categoryRepository.findAll()
                .stream()
                .flatMap(s -> s.getProducts().stream())
                .collect(Collectors.toList());
        order.setCurrency(orderDto.getCurrency());
        orderDto.getOrderItems().forEach(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(products.stream().filter(p -> p.getCode().equals(item.getCode())).findFirst().get());
//          System.out.println(orderItem.getProduct().getDescription());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setTotalPriceEuro(orderItem.getQuantity() * orderItem.getProduct().getPrice());
            order.getItems().add(orderItem);
        });
        order.setTotalPriceEuro(order.getItems().stream().map(i -> i.getTotalPriceEuro()).reduce(0d,Double::sum));

        return  order;
    }
}
