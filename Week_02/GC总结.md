### 作业一

1. 运行机器配置   i5 4核8G内存
2.  运行命令

 在包下的类，在Java源文件的地方编译后，需要到最外层包的上一级目录下运行，而且类前面需要带包名，以.隔开。

```shell
java -XX:+UseSerialGC -Xms128m -Xmx128m -XX:+PrintGCDetails demo.geekbang.com.GCLogAnalysis -- 串行
java -XX:+UseParallelGC  -Xms128m -Xmx128m -XX:+PrintGCDetails demo.geekbang.com.GCLogAnalysis -- 并行
java -XX:+UseConcMarkSweepGC  -Xms128m -Xmx128m -XX:+PrintGCDetails demo.geekbang.com.GCLogAnalysis --CMS 
java -XX:+UseG1GC  -Xms128m -Xmx128m -XX:+PrintGCDetails demo.geekbang.com.GCLogAnalysis --G1
```

此次分别测试内存级别为：128m、512M、1G、2G、4G

1. 当使用128m进行测试时，均出现OOM异常

   ```java
   Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
           at demo.geekbang.com.GCLogAnalysis.generateGarbage(GCLogAnalysis.java:50)
           at demo.geekbang.com.GCLogAnalysis.main(GCLogAnalysis.java:27)
   Heap
    PSYoungGen      total 29184K, used 14720K [0x00000000fd580000, 0x0000000100000000, 0x0000000100000000)
     eden space 14848K, 99% used [0x00000000fd580000,0x00000000fe3e0088,0x00000000fe400000)
     from space 14336K, 0% used [0x00000000fe400000,0x00000000fe400000,0x00000000ff200000)
     to   space 14336K, 0% used [0x00000000ff200000,0x00000000ff200000,0x0000000100000000)
    ParOldGen       total 87552K, used 87098K [0x00000000f8000000, 0x00000000fd580000, 0x00000000fd580000)
     object space 87552K, 99% used [0x00000000f8000000,0x00000000fd50eb40,0x00000000fd580000)
    Metaspace       used 2734K, capacity 4486K, committed 4864K, reserved 1056768K
     class space    used 294K, capacity 386K, committed 512K, reserved 1048576K
   
   ```

2. 其他内存级别未出现OOM
3. 横向比较：串行、并行、CMS G1生成的对象都有一个先上升后下降的现象。进一步分析TODO



### 作业二



步骤：

1. java -jar gateway-server-0.0.1-SNAPSHOT.jar

2. java -jar gateway-server-0.0.1-SNAPSHOT.jar 