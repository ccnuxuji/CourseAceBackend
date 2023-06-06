package com.ccnuxuji.courseace.service;

import com.ccnuxuji.courseace.pojo.Product;
import com.ccnuxuji.courseace.pojo.Topic;
import org.springframework.data.domain.Example;

import java.util.List;

public interface IProductService {

    void add(Product bean);

    void delete(Integer id);

    void update(Product product);

    Product get(Integer id);

    List<Product> getProducts(Example<Product> ex);

    List<Product> getProductsByTopic(Topic topic);

    List<Product> getProducts();
}
