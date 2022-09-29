package cn.fengchaolee.springboot.learn.service;

import cn.fengchaolee.springboot.learn.model.Person;
import org.springframework.stereotype.Service;

/**
 * PersonService
 *
 * @author fengchaolee
 * @date : 2022/9/29
 */
@Service
public class PersonService {

    public Person getPerson(){
        return Person.newBuilder().addName("zsf").addAge(19).build();
    }
}
