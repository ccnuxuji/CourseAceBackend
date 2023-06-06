package com.ccnuxuji.courseace.web;

import com.ccnuxuji.courseace.pojo.User;
import com.ccnuxuji.courseace.service.IUserService;
import com.ccnuxuji.courseace.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @Resource(name = "UserServiceImpl")
    IUserService iUserService;

    @PostMapping("/user")
    public Result addUser(@RequestBody User bean) throws Exception {
        iUserService.add(bean);
        return Result.success();
    }

    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable(value = "id") Integer id) throws Exception{
        iUserService.delete(id);
        return Result.success();
    }

    @PutMapping("/user")
    public Result updateUser(@RequestBody User bean) throws Exception{
        iUserService.update(bean);
        return Result.success();
    }

    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable(value = "id") Integer id) throws Exception{
        User bean = iUserService.get(id);
        return Result.success(bean);
    }
}
