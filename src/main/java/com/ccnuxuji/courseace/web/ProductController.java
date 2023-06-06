package com.ccnuxuji.courseace.web;

import com.ccnuxuji.courseace.pojo.Product;
import com.ccnuxuji.courseace.pojo.Topic;
import com.ccnuxuji.courseace.service.IProductService;
import com.ccnuxuji.courseace.service.ITopicService;
import com.ccnuxuji.courseace.util.Result;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProductController {
    @Resource(name = "ProductServiceImpl")
    IProductService iProductService;
    @Resource(name = "TopicServiceImpl")
    ITopicService iTopicService;

    @PostMapping("/product")
    public Result addProduct(@RequestBody Product bean) {
        Topic obj = new Topic();
        obj.setId(bean.getTopic_id());
        bean.setTopic(obj);
        System.out.println(bean);
        iProductService.add(bean);
        return Result.success();
    }

    @DeleteMapping("/product/{id}")
    public Result deleteProduct(@PathVariable("id") Integer id) {
        iProductService.delete(id);
        return Result.success();
    }

    @PutMapping("/product")
    public Result updateProduct(@RequestBody Product bean) {
        Topic obj = new Topic();
        obj.setId(bean.getTopic_id());
        bean.setTopic(obj);
        iProductService.update(bean);
        return Result.success();
    }

    @GetMapping("/product/{id}")
    public Result getProduct(@PathVariable("id") Integer id) {
        Product bean = iProductService.get(id);
        return Result.success(bean);
    }


    @GetMapping("/products")
    public Object getProducts() {
        return iProductService.getProducts();
    }

    @GetMapping("/products_topic")
    public Object getProductByTopic(@RequestParam(value = "tid") int tid) {
        Topic topic = iTopicService.get(tid);
        return iProductService.getProductsByTopic(topic);
    }
}
