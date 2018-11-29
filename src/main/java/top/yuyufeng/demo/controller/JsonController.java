package top.yuyufeng.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.yuyufeng.demo.vo.UserVO;

/**
 * @author yuyufeng
 * @date 2018/11/29.
 */
@RestController
@RequestMapping("json")
public class JsonController {
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    UserVO hello(@RequestBody UserVO userVO) {
        userVO.setAge(userVO.getAge() + 1);
        return userVO;
    }
}
