package java0.conc0301;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {
    private static String result;

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t = new Thread(() -> {
            try {
                result = new Demo().hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        t.start();

        countDownLatch.await();
        System.out.println("异步计算结果为：" + result);
    }
}
