package lesson15;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpTest {
    public static void main(String args[]) {
        //创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        HttpGet httpGet = new HttpGet("http://www.gxnu.edu.cn/default.html");
        System.out.println(httpGet.getRequestLine());
        try {
            //执行get请求
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            //获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            //响应状态
            System.out.println("status:" + httpResponse.getStatusLine());
            //判断响应实体是否为空
/*            if (entity != null) {
                System.out.println("contentEncoding:" + entity.getContentEncoding());
                System.out.println("response content:" + EntityUtils.toString(entity));
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {               
            	//关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}