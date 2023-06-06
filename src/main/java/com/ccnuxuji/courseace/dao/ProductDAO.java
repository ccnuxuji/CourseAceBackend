package com.ccnuxuji.courseace.dao;

import com.ccnuxuji.courseace.pojo.Product;
import com.ccnuxuji.courseace.pojo.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    List<Product> findProductsByTopicOrderByOrd(Topic topic);
}
