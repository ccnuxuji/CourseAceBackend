package com.ccnuxuji.courseace.service;

import com.ccnuxuji.courseace.pojo.Chapter;
import com.ccnuxuji.courseace.pojo.Product;
import org.springframework.data.domain.Example;

import java.util.List;

public interface IChapterService {
    void add(Chapter bean);

    void delete(Integer id);

    void update(Chapter bean);

    Chapter get(Integer id);

    List<Chapter> getChapters(Example<Chapter> ex);

    List<Chapter> getChaptersByProduct(Product product);

}
