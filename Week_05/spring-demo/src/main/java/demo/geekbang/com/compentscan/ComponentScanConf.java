package demo.geekbang.com.compentscan;

import demo.geekbang.com.bean.Klass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ComponentScanConf {

    @Bean
    public Klass getKlass(){
        return new Klass();
    }
}
