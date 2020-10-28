package demo.geekbang.com.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author romanlu
 */
public class OkHttpDemo {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder().url("http://localhost:8081").build();
            Response response = client.newCall(request).execute();
            //打印结果
            System.out.println(response.body().string());
        } finally {
            client.clone();
        }
    }
}
