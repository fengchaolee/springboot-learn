package cn.fengchaolee.springboot.learn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Person
 *
 * @author fengchaolee
 * @date : 2022/9/29
 */

@Getter
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private Character sex;

    public static Builder newBuilder(){
        return new Builder();
    }

    public static class Builder{
        private String name;
        private Integer age;
        private Character sex;

        public Builder addName(String name){
            this.name = name;
            return this;
        }

        public Builder addAge(Integer age){
            this.age = age;
            return this;
        }

        public Builder addSex(Character sex){
            this.sex = sex;
            return this;
        }

        public Person build(){
            return new Person(this.name, this.age, this.sex);
        }
    }
}
