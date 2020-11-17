package demo.geekbang.com;

import demo.geekbang.com.autoconfiguration.StudentAutoConfiguration;
import demo.geekbang.com.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = StudentAutoConfiguration.class)
public class AutoConfigurationDemo {

    @Autowired
    private Student student;

    @Test
    public void starterTest() {
        System.out.printf(student.toString());
        student.init();
    }
}
