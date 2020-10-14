package com.ds.order.configuration;

import com.ds.order.domain.Category;
import com.ds.order.domain.Product;
import com.ds.order.repository.CategoryRepository;
import com.ds.order.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
@AllArgsConstructor
public class InitRunner implements CommandLineRunner {
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Category> categories = this.categoryRepository.findAll();
        String[] categoryNames = {"Appetizers", "Salads", "Main Dishes", "Drinks"};
        if (categories.isEmpty()) {
            Category category1 = new Category();
            category1.setName("Appetizers");

            Product product11 = new Product();
            product11.setCode("1.1");
            product11.setPrice(15.0);
            product11.setDescription("Pasta Chips");

            Product product12 = new Product();
            product12.setCode("1.2");
            product12.setDescription("Chicken Parm Egg Rolls");
            product12.setPrice(13.0);

            Product product13 = new Product();
            product13.setCode("1.3");
            product13.setDescription("Pull Apart Pigs In A Blanket");
            product13.setPrice(20.0);

            category1.getProducts().add(product11);
            category1.getProducts().add(product12);
            category1.getProducts().add(product13);


            Category category2 = new Category();
            category2.setName("Salads");

            Product product21 = new Product();
            product21.setPrice(15.0);
            product21.setCode("2.1");
            product21.setDescription("Lettuce, avocado and mango salad");

            Product product22 = new Product();
            product22.setPrice(15.0);
            product22.setCode("2.2");
            product22.setDescription("Crunchy noodle salad");

            Product product23 = new Product();
            product23.setPrice(15.0);
            product23.setCode("2.3");
            product23.setDescription("Ripper Thai beef noodle salad");

            category2.getProducts().add(product21);
            category2.getProducts().add(product22);
            category2.getProducts().add(product23);

            Category category3 = new Category();
            category3.setName("Main Dishes");

            Product product31 = new Product();
            product31.setPrice(20.0);
            product31.setCode("3.1");
            product31.setDescription("Stir Fry Noodles with Chicken");

            Product product32 = new Product();
            product32.setPrice(23.0);
            product32.setCode("3.2");
            product32.setDescription("Crispy Chilli Beef Noodles ");

            Product product33 = new Product();
            product33.setPrice(30.0);
            product33.setCode("3.3");
            product33.setDescription("Asian Spiced Pork Tenderloins with Apricot Sauce");

            category3.getProducts().add(product31);
            category3.getProducts().add(product32);
            category3.getProducts().add(product33);


            Category category4 = new Category();
            category4.setName("Drinks");

            Product product41 = new Product();
            product41.setPrice(3.0);
            product41.setCode("4.1");
            product41.setDescription("White Tea");

            Product product42 = new Product();
            product42.setPrice(2.5);
            product42.setCode("4.2");
            product42.setDescription("Coca Cola");

            Product product43 = new Product();
            product43.setPrice(4.0);
            product43.setCode("4.3");
            product43.setDescription("Ayran");

            category4.getProducts().add(product41);
            category4.getProducts().add(product42);
            category4.getProducts().add(product43);

            this.categoryService.createCategory(category1);
            this.categoryService.createCategory(category2);
            this.categoryService.createCategory(category3);
            this.categoryService.createCategory(category4);
        }
    }

}

