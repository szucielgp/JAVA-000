package demo.geekbang.com.autoconfiguration;


import demo.geekbang.com.bean.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Student.class)
@EnableConfigurationProperties({StudentProperties.class})
@ConditionalOnProperty(prefix = "student", value = "enabled", havingValue = "true", matchIfMissing = true)
public class StudentAutoConfiguration {

    @Bean
    public Student getStudent(StudentProperties studentProperties) {
        return new Student(studentProperties.getId(), studentProperties.getName());
    }
}
