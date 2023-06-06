package com.ccnuxuji.courseace.service;

import com.ccnuxuji.courseace.pojo.User;

public interface IUserService {

    void add(User user);

    void delete(Integer id);

    void update(User user);

    User get(Integer id);

    boolean isExist(String name);

    User getByName(String name);

    User get(String name, String password);

}
