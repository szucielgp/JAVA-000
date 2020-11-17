package demo.geekbang.com.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyStudent implements Serializable {

    private int id;
    private String name;

    public void init() {
        System.out.println("hello...student");
    }

    public MyStudent create() {
        return new MyStudent(101, "KK101");
    }
}
