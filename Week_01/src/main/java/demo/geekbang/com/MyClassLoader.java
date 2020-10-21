package demo.geekbang.com;

import java.io.*;
import java.lang.reflect.Method;

/**
 * 自定义class loader, 对Hello.xlass文件分别进行255-x操作
 *
 * @author romanlu
 * @date 2020.10.21
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = new MyClassLoader().findClass("Hello");
        Object o = clazz.newInstance();
        //调用hello方法
        Method hellMethod = clazz.getDeclaredMethod("hello", null);
       // 运行结果： Hello, classLoader!
        hellMethod.invoke(o);
    }

    @Override
    protected Class<?> findClass(String name) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fin = new FileInputStream(this.getClass().getClassLoader().getResource("Hello.xlass").getFile())) {
            byte[] buffer = new byte[1];
            int length = -1;
            while ((length = fin.read(buffer, 0, buffer.length)) != -1) {
                buffer[0] = (byte) (255 - buffer[0]);
                baos.write(buffer, 0, length);
            }
            baos.flush();
            byte[] resultByteArr = baos.toByteArray();
            return defineClass(name, resultByteArr, 0, resultByteArr.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
