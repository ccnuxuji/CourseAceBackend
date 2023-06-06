package com.ccnuxuji.courseace.serviceImpl;

import com.ccnuxuji.courseace.dao.ProductDAO;
import com.ccnuxuji.courseace.pojo.Product;
import com.ccnuxuji.courseace.pojo.Topic;
import com.ccnuxuji.courseace.service.IProductService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements IProductService {
    @Resource
    ProductDAO productDAO;

    @Override
    public void add(Product bean) {
        productDAO.save(bean);
    }

    @Override
    public void delete(Integer id) {
        productDAO.deleteById(id);
    }

    @Override
    public void update(Product product) {
        productDAO.save(product);
    }

    @Override
    public Product get(Integer id) {
        return productDAO.findById(id).get();
    }

    @Override
    public List<Product> getProducts(Example<Product> ex) {
        return productDAO.findAll(ex, Sort.by(Sort.Direction.ASC, "ord"));
    }

    @Override
    public List<Product> getProducts() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> getProductsByTopic(Topic topic) {
        return productDAO.findProductsByTopicOrderByOrd(topic);
    }
}
