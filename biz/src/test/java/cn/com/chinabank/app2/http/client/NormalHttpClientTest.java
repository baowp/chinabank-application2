package cn.com.chinabank.app2.http.client;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 1/16/14
 * Time: 10:11 PM
 */
public class NormalHttpClientTest {

    private NormalHttpClient normalHttpClient = new NormalHttpClient();

    @Test
    public void testPost() {
        String url = "http://localhost:12080/hessian/hello";
        byte[] bytes = new byte[]{99, 2, 0, 109, 0, 7, 115, 101, 116, 85, 115, 101, 114, 77, 116, 0, 41, 99, 110, 46, 99, 111, 109, 46, 99, 104, 105, 110, 97, 98, 97, 110, 107, 46, 97, 112, 112, 50, 46, 104, 101, 115, 115, 105, 97, 110, 46, 101, 110, 116, 105, 116, 121, 46, 85, 115, 101, 114, 83, 0, 8, 117, 115, 101, 114, 78, 97, 109, 101, 83, 0, 4, 74, 97, 99, 107, 83, 0, 8, 112, 97, 115, 115, 119, 111, 114, 100, 83, 0, 3, 49, 50, 51, 122, 122, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        HttpEntity httpEntity = new ByteArrayEntity(bytes);
        String result = normalHttpClient.post(url, httpEntity);
        System.out.println(result);
    }
}
