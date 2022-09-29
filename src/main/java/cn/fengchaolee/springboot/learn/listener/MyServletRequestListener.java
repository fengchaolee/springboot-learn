package cn.fengchaolee.springboot.learn.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * MyServletRequestListener
 * 参见 https://blog.csdn.net/yao_wen_yu/article/details/110430974
 * @author fengchaolee
 * @date : 2022/9/29
 */
@Component
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // ServletRequestListener.super.requestDestroyed(sre);
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        request.setAttribute("name", "zsf");
        System.out.println("MyServletRequestListener requestInitialized...");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // ServletRequestListener.super.requestInitialized(sre);
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        String name = (String) request.getAttribute("name");
        System.out.println("MyServletRequestListener requestDestroyed..." + name);
    }
}
