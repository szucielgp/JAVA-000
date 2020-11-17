package demo.geekbang.com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class School {
    List<Klass> classes;
}
