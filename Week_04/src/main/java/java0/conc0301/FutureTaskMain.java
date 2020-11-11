package java0.conc0301;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author romanlu
 * @date
 */
public class FutureTaskMain {

    public static void main(String[] args) {
        System.out.println("这是主线程：");

        ThreadC threadC = new ThreadC();
        FutureTask<String> futureTask = new FutureTask<>(threadC);
        new Thread(futureTask).start();
        System.out.println("这是主线程:begin!");
        try {
            System.out.println("得到的返回结果是:" + futureTask.get());
            System.out.printf("主线程退出");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
