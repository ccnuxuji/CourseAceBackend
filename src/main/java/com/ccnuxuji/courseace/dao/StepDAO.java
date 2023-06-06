package com.ccnuxuji.courseace.dao;

import com.ccnuxuji.courseace.pojo.Chapter;
import com.ccnuxuji.courseace.pojo.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StepDAO extends JpaRepository<Step, Integer> {

    List<Step> findStepsByChapterOrderByOrd(Chapter chapter);
}
