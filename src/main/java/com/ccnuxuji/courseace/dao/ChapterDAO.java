package com.ccnuxuji.courseace.dao;

import com.ccnuxuji.courseace.pojo.Chapter;
import com.ccnuxuji.courseace.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterDAO extends JpaRepository<Chapter, Integer> {

    List<Chapter> getChaptersByProductOrderByOrd(Product product);
}
