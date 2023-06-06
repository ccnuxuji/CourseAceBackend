package com.ccnuxuji.courseace.web;

import com.ccnuxuji.courseace.pojo.Topic;
import com.ccnuxuji.courseace.service.ITopicService;
import com.ccnuxuji.courseace.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TopicController {
    @Resource(name = "TopicServiceImpl")
    ITopicService iTopicService;

    @PostMapping("/topic")
    public Result addTopic(@RequestBody Topic bean) {
        iTopicService.add(bean);
        return Result.success();
    }

    @DeleteMapping("/topic/{id}")
    public Result deleteTopic(@PathVariable(value = "id") Integer id) {
        iTopicService.delete(id);
        return Result.success();
    }

    @PutMapping("/topic")
    public Result updateTopic(@RequestBody Topic bean) {
        iTopicService.update(bean);
        return Result.success();
    }

    @GetMapping("/topic/{id}")
    public Result getTopic(@PathVariable(value = "id") Integer id) throws Exception{
        Topic bean = iTopicService.get(id);
        return Result.success(bean);
    }

    @GetMapping("/topics")
    public List<Topic> getTopics() {
        return iTopicService.list();
    }

}
