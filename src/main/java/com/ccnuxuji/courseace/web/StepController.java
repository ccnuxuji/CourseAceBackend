package com.ccnuxuji.courseace.web;

import com.ccnuxuji.courseace.pojo.Chapter;
import com.ccnuxuji.courseace.pojo.Step;
import com.ccnuxuji.courseace.service.IChapterService;
import com.ccnuxuji.courseace.service.IStepService;
import com.ccnuxuji.courseace.util.*;
import com.ccnuxuji.courseace.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class StepController {
    @Resource(name = "StepServiceImpl")
    IStepService iStepService;
    @Resource(name = "ChapterServiceImpl")
    IChapterService iChapterService;


    @PostMapping("/step")
    public Result addStep(@RequestBody Step bean) throws Exception {
        Chapter obj = new Chapter();
        obj.setId(bean.getChapter_id());
        bean.setChapter(obj);
        iStepService.add(bean);
        return Result.success();
    }

    @DeleteMapping("/step/{id}")
    public Result deleteStep(@PathVariable(value = "id") int id) throws Exception {
        iStepService.delete(id);
        return Result.success();
    }

    @PutMapping("/step")
    public Result updateStep(@RequestBody Step bean) throws Exception {
        System.out.println("测试cid" + bean.getChapter_id());
        Chapter obj = new Chapter();
        obj.setId(bean.getChapter_id());
        bean.setChapter(obj);
        iStepService.update(bean);
        return Result.success();
    }

    @GetMapping("/step/{id}")
    public Result getStep(@PathVariable(value = "id") int id) throws Exception {
        Step bean = iStepService.get(id);
        return Result.success(bean);
    }

    @GetMapping("/steps_chapter")
    public Object getStepsByChapter(@RequestParam(value = "cid") Integer cid) {
        Chapter chapter = iChapterService.get(cid);
        return iStepService.getStepsByChapter(chapter);
    }

    @GetMapping("/search")
    public Page4Navigator<Chapter> search(@RequestParam(value = "keyword") String keyword,
                                       @RequestParam(value = "start", defaultValue = "0") int start,
                                       @RequestParam(value = "size", defaultValue = "5") int size) {
        return null;
    }

}
