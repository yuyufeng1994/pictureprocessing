package top.yuyufeng.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuyufeng
 * @date 2018/11/29.
 */
@RestController
public class IndexController {
    @RequestMapping("/hello")
    String hello(){
        return "hello";
    }
}
