package com.ds.order.rest;

import com.ds.order.domain.Category;
import com.ds.order.domain.CurrencyEnum;
import com.ds.order.dto.Currency;
import com.ds.order.external.CurrencyExternal;
import com.ds.order.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/menu")
@AllArgsConstructor
public class CategoryRest {

    private final CategoryService categoryService;
    private final CurrencyExternal currencyExternal;


    @GetMapping
    @ApiOperation(value = "View the menu (EURO)")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("{currency}")
    @ApiOperation(value = "View the menu to other currencies(CAD,HKD,PHP,USD)")
    public List<Category> getCategoriesWithCurrency( @PathVariable CurrencyEnum currency){
        Currency currentCurrency = this.currencyExternal.getCurrentCurrency();
        List<Category> categories = this.categoryService.getCategories();
        System.out.println(categories);
        switch (currency){
            case USD:
                categories.forEach(category -> {
                    category.getProducts().forEach(product -> {
                        product.setPriceCurrency(product.getPrice() * currentCurrency.getRates().getUSD());
                    });
                });
                break;

            case CAD:
                categories.forEach(category -> {
                    category.getProducts().forEach(product -> {
                        product.setPriceCurrency(product.getPrice() * currentCurrency.getRates().getCAD());
                    });
                });
                break;
            case HKD:
                categories.forEach(category -> {
                    category.getProducts().forEach(product -> {
                        product.setPriceCurrency(product.getPrice() * currentCurrency.getRates().getHKD());
                    });
                });
                break;
            case PHP:
                categories.forEach(category -> {
                    category.getProducts().forEach(product -> {
                        product.setPriceCurrency(product.getPrice() * currentCurrency.getRates().getPHP());
                    });
                });
                break;

            default:
                break;
        }
        return categories;
    }

}
