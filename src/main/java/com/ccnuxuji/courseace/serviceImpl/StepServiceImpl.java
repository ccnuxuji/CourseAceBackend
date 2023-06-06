package com.ccnuxuji.courseace.serviceImpl;

import com.ccnuxuji.courseace.dao.StepDAO;
import com.ccnuxuji.courseace.pojo.Chapter;
import com.ccnuxuji.courseace.pojo.Step;
import com.ccnuxuji.courseace.service.IStepService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StepServiceImpl")
public class StepServiceImpl implements IStepService {
    @Resource
    StepDAO stepDAO;
    @Override
    public void add(Step step) {
        stepDAO.save(step);
    }

    @Override
    public void delete(Integer id) {
        stepDAO.deleteById(id);
    }

    @Override
    public void update(Step step) {
        stepDAO.save(step);
    }

    @Override
    public Step get(Integer id) {
        return stepDAO.findById(id).get();
    }

    @Override
    public List<Step> getStepsByChapter(Chapter chapter) {
        return stepDAO.findStepsByChapterOrderByOrd(chapter);
    }

}
