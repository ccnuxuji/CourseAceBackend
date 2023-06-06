package com.ccnuxuji.courseace.service;

import com.ccnuxuji.courseace.pojo.Chapter;
import com.ccnuxuji.courseace.pojo.Step;

import java.util.List;

public interface IStepService {
    void add(Step step);

    void delete(Integer step);

    void update(Step step);

    Step get(Integer id);

    List<Step> getStepsByChapter(Chapter chapter);
}
