项目基于gradle构建

gradle版本为：6.6.1

spring-boot版本为：2.4.0

#### 模块1：bean的装配，database代码实现（spring-demo）

1.实现了基于xml/configuration/ 引入starter  3种装配模式
代码路径：https://github.com/szucielgp/JAVA-000/tree/main/Week_05/spring-demo/src/main/java/demo/geekbang/com
2.preparestatement等相关操作及HikariCP 操作db
代码路径：https://github.com/szucielgp/JAVA-000/tree/main/Week_05/spring-demo/src/main/java/demo/geekbang/com/database

上述单元测试的路径：
https://github.com/szucielgp/JAVA-000/tree/main/Week_05/spring-demo/src/test/java/com.geekbang.demo

#### 模块2：自定义实现starter （starter-demo）
自定义starter实现，实现了自动化装配student等类
代码路径：https://github.com/szucielgp/JAVA-000/blob/main/Week_05/starter-demo/src/main/java/demo/geekbang/com
测试路径：https://github.com/szucielgp/JAVA-000/blob/main/Week_05/starter-demo/src/test/java/demo/geekbang/com