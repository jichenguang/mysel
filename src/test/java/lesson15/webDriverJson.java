package lesson15;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class webDriverJson {
	String Url ="http://adminprodq.700paper.cn/admin/product/create";
    private static String base = "http://127.0.0.1:4444/wd/hub/session/";
    private static String elementId;
    static String sessionId = "";
    static String MyName = "ctl00$ContentPlaceHolder1$hdProductId";

    public static void main(String[] args) throws Exception, IOException {

        HttpClient httpClient = HttpClients.createDefault();
        
        JsonObject setCapability = new JsonObject();
        setCapability.addProperty("browserName","firefox");
        JsonObject capability = new JsonObject();
        capability.add("desiredCapabilities",setCapability);
        HttpPost httpPost = new HttpPost(base);
        //create session         
        postExecutor(httpClient, httpPost, capability);
 
        String url = base + sessionId + "/url";
         httpPost = new HttpPost(url);
         
        JsonObject getUrl = new JsonObject();
        getUrl.addProperty("url", "http://www.baidu.com");

        postExecutor(httpClient, httpPost, getUrl);

        //find input box
        url = base + sessionId + "/element";
        httpPost = new HttpPost(url);
        JsonObject findElement = new JsonObject();
        findElement.addProperty("using", "id");
        findElement.addProperty("value", "kw");
        postExecutor(httpClient, httpPost, findElement);

        System.out.println(elementId);
        
        url = base + sessionId + "/element/"+elementId+"/value";
        httpPost = new HttpPost(url);
        JsonObject typeElement = new JsonObject();
        
        String json = "{\"value\":[\"webdriver\"]}";
        JsonParser jp = new JsonParser();
        typeElement = (JsonObject) jp.parse(json);
     
        postExecutor(httpClient, httpPost, typeElement);
        
        //find search button
        
        url = base + sessionId + "/element";
        httpPost = new HttpPost(url);
        JsonObject findSearchButton = new JsonObject();
        findSearchButton.addProperty("using", "id");
        findSearchButton.addProperty("value", "su");
        postExecutor(httpClient, httpPost, findSearchButton);
        System.out.println(elementId);
        
        url = base + sessionId + "/element/"+elementId+"/click";
        httpPost = new HttpPost(url);
        postExecutor(httpClient, httpPost,null);
        
        //delete session
         url = base + sessionId ;
         HttpDelete httpDelete = new HttpDelete(url);
         
         

        deleteExecutor(httpClient, httpDelete);

    }

 

    /**
     * @author Young
     * @param httpClient
     * @param httpPost
     * @param jo
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static void postExecutor(HttpClient httpClient, HttpPost httpPost,
            JsonObject jo) throws UnsupportedEncodingException, IOException,
            ClientProtocolException {
        if(jo!=null)
        {
            StringEntity input = new StringEntity(jo.toString());
            input.setContentEncoding("UTF-8");
            input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                    "application/json"));
            httpPost.setEntity(input);
        }
        
        HttpResponse response = httpClient.execute(httpPost);

        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("Response content length: "
                        + entity.getContentLength());

                String resultEntity = EntityUtils.toString(entity);
                System.out.println("Response content: " + resultEntity);
                JsonObject result= new JsonParser().parse(resultEntity).getAsJsonObject();
                JsonElement  sessionIdJson = result.get("sessionId");
                if(!sessionIdJson.isJsonNull())
                sessionId =sessionIdJson.getAsString();
                JsonElement  valueJson = result.get("value");
                
             
                if(!valueJson.isJsonNull())
                {
                    JsonObject tm=valueJson.getAsJsonObject();
                    JsonElement elementIdJson = tm.get("ELEMENT");
                    if(elementIdJson!=null)
                    elementId=elementIdJson.getAsString();
                   
                }
             

            }
        } finally {
            ((Closeable) response).close();
        }
    }

    
    /**
     * @author Young
     * @param httpClient
     * @param delete
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static void deleteExecutor(HttpClient httpClient, HttpDelete delete) throws UnsupportedEncodingException, IOException,
            ClientProtocolException {
        
        HttpResponse response = httpClient.execute(delete);

        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("Response content length: "
                        + entity.getContentLength());

                String resultEntity = EntityUtils.toString(entity);
                System.out.println("Response content: " + resultEntity);
                JsonObject result= new JsonParser().parse(resultEntity).getAsJsonObject();
                JsonElement  sessionIdJson = result.get("sessionId");
                if(!sessionIdJson.isJsonNull())
                sessionId =sessionIdJson.getAsString();
                JsonElement  valueJson = result.get("value");
                
             
                if(!valueJson.isJsonNull())
                {
                    JsonObject tm=valueJson.getAsJsonObject();
                    JsonElement elementIdJson = tm.get("ELEMENT");
                    if(elementIdJson!=null)
                    elementId=elementIdJson.getAsString();
                   
                }
             

            }
        } finally {
            ((Closeable) response).close();
        }
    }

}