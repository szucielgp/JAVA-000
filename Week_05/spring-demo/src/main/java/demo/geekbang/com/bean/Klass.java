package demo.geekbang.com.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Klass {

    String className;

    List<MyStudent> myStudents;

    public void dong() {
        System.out.println(this.getMyStudents());
    }

}
