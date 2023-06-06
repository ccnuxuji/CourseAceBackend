package com.ccnuxuji.courseace.web;

import com.ccnuxuji.courseace.pojo.Chapter;
import com.ccnuxuji.courseace.pojo.Product;
import com.ccnuxuji.courseace.service.IChapterService;
import com.ccnuxuji.courseace.service.IProductService;
import com.ccnuxuji.courseace.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ChapterController {
    @Resource(name = "ChapterServiceImpl")
    IChapterService iChapterService;
    @Resource(name = "ProductServiceImpl")
    IProductService iProductService;

    @PostMapping("/chapter")
    public Result addChapter(@RequestBody Chapter bean) throws Exception {
        Product product = new Product();
        product.setId(bean.getProduct_id());
        bean.setProduct(product);
        iChapterService.add(bean);
        return Result.success();
    }

    @DeleteMapping("/chapter/{id}")
    public Result deleteChapter(@PathVariable(value = "id") Integer id) throws Exception {
        iChapterService.delete(id);
        return Result.success();
    }

    @PutMapping("/chapter")
    public Result updateChapter(@RequestBody Chapter bean) throws Exception {
        Product product = new Product();
        product.setId(bean.getProduct_id());
        bean.setProduct(product);
        iChapterService.update(bean);
        return Result.success();
    }

    @GetMapping("/chapter/{id}")
    public Result getChapter(@PathVariable(value = "id") Integer id) throws Exception {
        Chapter bean = iChapterService.get(id);
        return Result.success(bean);
    }

    @GetMapping("/chapters_product")
    public Object getChaptersByProduct(@RequestParam(value = "pid") Integer pid) {
        Product product = iProductService.get(pid);
        System.out.println("test");
        return iChapterService.getChaptersByProduct(product);
    }

}
