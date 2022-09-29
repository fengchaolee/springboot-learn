package cn.fengchaolee.springboot.learn.controller;

import cn.fengchaolee.springboot.learn.model.Person;
import cn.fengchaolee.springboot.learn.model.ResultJSON;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * PersonController
 *
 * @author fengchaolee
 * @date : 2022/9/29
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/getPerson")
    public ResultJSON getPerson(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        Person person = (Person)servletContext.getAttribute("person");
        return ResultJSON.success(JSON.parseObject(JSON.toJSONString(person)));
    }
}
