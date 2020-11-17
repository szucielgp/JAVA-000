package com.geekbang.demo;

import demo.geekbang.com.Application;
import demo.geekbang.com.bean.Klass;
import demo.geekbang.com.javaconf.JavaConfig;
import demo.geekbang.com.xml.XmlBeanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class BeanConfTest {
    @Autowired
    private XmlBeanConfig xmlBeanConfig;

    @Autowired
    private JavaConfig javaConfig;

    @Autowired
    private Klass klass;



    @Test
    public void xmlTest() {
        //School(classes=[Klass(students=[Student(id=1, name=gavin), Student(id=2, name=roman)])])
        System.out.println(xmlBeanConfig.getSchool().toString());
    }

    @Test
    public void javaConfTest() {
        System.out.println(javaConfig.getStudent().toString());
    }

    @Test
    public void compentScanTest() {
        System.out.println(klass.toString());
    }

}
