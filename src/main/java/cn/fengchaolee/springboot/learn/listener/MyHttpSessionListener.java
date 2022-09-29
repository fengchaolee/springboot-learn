package cn.fengchaolee.springboot.learn.listener;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * MyHttpSessionListener
 * 参见 https://blog.csdn.net/yao_wen_yu/article/details/110430974
 * @author fengchaolee
 * @date : 2022/9/29
 */
@Component
public class MyHttpSessionListener implements HttpSessionListener {
    public int cnt = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // HttpSessionListener.super.sessionCreated(se);
        cnt++;
        se.getSession().getServletContext().setAttribute("cnt", cnt);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // HttpSessionListener.super.sessionDestroyed(se);
        cnt--;
        se.getSession().getServletContext().setAttribute("cnt", cnt);
    }
}
