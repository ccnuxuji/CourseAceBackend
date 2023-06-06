package com.ccnuxuji.courseace.serviceImpl;

import com.ccnuxuji.courseace.dao.UserDAO;
import com.ccnuxuji.courseace.pojo.User;
import com.ccnuxuji.courseace.service.IUserService;
import com.ccnuxuji.courseace.util.SpringContextUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {

    @Resource
    UserDAO userDAO;

    @Override
    public void add(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(Integer id) {
        userDAO.deleteById(id);
    }

    @Override
    public void update(User bean) {
        userDAO.save(bean);
    }

    @Override
    public User get(Integer id) {
        return userDAO.findById(id).get();
    }

    @Override
    public boolean isExist(String name) {
        UserServiceImpl userServiceImpl = SpringContextUtil.getBean(UserServiceImpl.class);
        User user = userServiceImpl.getByName(name);
        return null != user;
    }

    @Override
    public User getByName(String name) {
        return userDAO.findByName(name);
    }

    @Override
    public User get(String name, String password) {
        return userDAO.getByNameAndPassword(name, password);
    }


}
