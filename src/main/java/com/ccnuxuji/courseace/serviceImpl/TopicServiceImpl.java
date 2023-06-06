package com.ccnuxuji.courseace.serviceImpl;

import com.ccnuxuji.courseace.dao.TopicDAO;
import com.ccnuxuji.courseace.pojo.Topic;
import com.ccnuxuji.courseace.service.ITopicService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TopicServiceImpl")
public class TopicServiceImpl implements ITopicService {
    @Resource
    TopicDAO topicDAO;

    @Override
    public void add(Topic bean) {
        topicDAO.save(bean);
    }

    @Override
    public void delete(Integer id) {
        topicDAO.deleteById(id);
    }

    @Override
    public void update(Topic bean) {
        topicDAO.save(bean);
    }

    @Override
    public Topic get(Integer id) {
        return topicDAO.findById(id).get();
    }

    @Override
    public List<Topic> list() {
        return topicDAO.findAll(Sort.by(Sort.Direction.ASC, "ord"));
    }

}
