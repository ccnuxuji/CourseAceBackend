package com.ccnuxuji.courseace.serviceImpl;

import com.ccnuxuji.courseace.dao.ChapterDAO;
import com.ccnuxuji.courseace.pojo.Chapter;
import com.ccnuxuji.courseace.pojo.Product;
import com.ccnuxuji.courseace.service.IChapterService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ChapterServiceImpl")
public class ChapterServiceImpl implements IChapterService {

    @Resource
    ChapterDAO chapterDAO;

    @Override
    public void add(Chapter bean) {
        chapterDAO.save(bean);
    }

    @Override
    public void delete(Integer id) {
        chapterDAO.deleteById(id);
    }

    @Override
    public void update(Chapter bean) {
        chapterDAO.save(bean);
    }

    @Override
    public Chapter get(Integer id) {
        return chapterDAO.findById(id).get();
    }

    @Override
    public List<Chapter> getChapters(Example<Chapter> ex) {
        return chapterDAO.findAll(ex, Sort.by(Sort.Direction.ASC, "ord"));
    }

    @Override
    public List<Chapter> getChaptersByProduct(Product product) {
        return chapterDAO.getChaptersByProductOrderByOrd(product);
    }

}
