package demo.geekbang.com.xml;

import demo.geekbang.com.bean.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class XmlBeanConfig {

    @Bean
    public School getSchool() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:BeanConfig.xml");
        School schlool = (School) context.getBean("school1");
        return schlool;
    }
}
