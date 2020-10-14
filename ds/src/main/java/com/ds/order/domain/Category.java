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
public class Category {
    @Id
    private String id;
    private String name;
    private List<Product> products = new ArrayList<>();



}
