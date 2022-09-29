package cn.fengchaolee.springboot.learn.listener;

import cn.fengchaolee.springboot.learn.model.Person;
import cn.fengchaolee.springboot.learn.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * MyApplicationListener
 *  参见 https://blog.csdn.net/yao_wen_yu/article/details/110430974
 * @author fengchaolee
 * @date : 2022/9/29
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //首先获去application上下文
        ApplicationContext applicationContext = event.getApplicationContext();
        //获取对应的service
        PersonService personService = applicationContext.getBean(PersonService.class);
        Person person = personService.getPerson();
        //获取application的域对象，将查到的信息放到application域中
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("person", person);
    }
}
