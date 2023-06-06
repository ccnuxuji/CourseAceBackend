package com.ccnuxuji.courseace.service;

import com.ccnuxuji.courseace.pojo.Topic;

import java.util.List;

public interface ITopicService {

    void add(Topic bean);

    void delete(Integer id);

    void update(Topic bean);

    Topic get(Integer id);

    List<Topic> list();
}

