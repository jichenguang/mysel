package lesson15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

@Test
public class HttpTestPost {
	
	
	@SuppressWarnings("deprecation")
	public static void test(){
	//创建HttpClientBuilder  
    HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
    //HttpClient  
    CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  

    HttpPost httpPost = new HttpPost("http://adminprodq.700paper.cn/admin/product/create");  
    httpPost.setConfig(null);  
    
    // 创建参数队列  
    List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
    formparams.add(new BasicNameValuePair("ctl00$ContentPlaceHolder1$hdProductId", "8888"));
     


    UrlEncodedFormEntity entity;  
    try {  
        entity = new UrlEncodedFormEntity(formparams, "UTF-8");  
        httpPost.setEntity(entity);  

        HttpResponse httpResponse;  
        //post请求  
        httpResponse = closeableHttpClient.execute(httpPost);  

        //getEntity()  
        HttpEntity httpEntity = httpResponse.getEntity();  
        if (httpEntity != null) {  
            //打印响应内容  
            System.out.println("response:" + EntityUtils.toString(httpEntity, "UTF-8"));  
           
        }  
        //释放资源  
        closeableHttpClient.close();  
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
	}

}