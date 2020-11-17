package demo.geekbang.com.javaconf;

import demo.geekbang.com.bean.MyStudent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public MyStudent getStudent() {
        return new MyStudent(1, "gavin");
    }
}
