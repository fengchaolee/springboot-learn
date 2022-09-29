package cn.fengchaolee.springboot.learn.controller;

import cn.fengchaolee.springboot.learn.model.ResultJSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * TestListenerController
 *
 * @author fengchaolee
 * @date : 2022/9/29
 */
@RestController
@RequestMapping("test")
public class TestListenerController {

    @GetMapping("total")
    public ResultJSON getNumberOfOnlineUsers(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie;
        try {
            String id = request.getSession().getId();
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(id, String.valueOf(StandardCharsets.UTF_8)));
            String contextPath = request.getContextPath();
            cookie.setPath(contextPath);
            cookie.setMaxAge((int) (0.5 * 60 * 60));
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int cnt = (int)request.getSession().getServletContext().getAttribute("cnt");
        return ResultJSON.success(cnt);
    }

    @GetMapping("getRequestAttr")
    public ResultJSON getRequestAttr(HttpServletRequest request){
        String name = (String) request.getAttribute("name");
        JSONObject jo = new JSONObject();
        jo.put("name", name);
        return ResultJSON.success(jo);
    }
}
