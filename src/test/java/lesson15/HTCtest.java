package lesson15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;


public class HTCtest {
	private CloseableHttpClient httpclient;

	public HTCtest() {
		this(null);
	}

	/**
	 * 代理方式
	 * 
	 * @param proxy
	 */
	public HTCtest(HttpProxy proxy) {
		if (proxy != null) {
			httpclient = getHttpClientWithProxy(proxy);
		} else {
			httpclient = HttpClients.createDefault();
		}
	}

	// 获得设置代理的httpClent实例
	private CloseableHttpClient getHttpClientWithProxy(HttpProxy proxy) {
		HttpHost proxyHost = new HttpHost(proxy.getHost(), proxy.getPort());
		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(new AuthScope(proxy.getHost(), proxy.getPort()),
				new UsernamePasswordCredentials(proxy.getUser(), proxy.getPassword()));

		return HttpClients.custom().setProxy(proxyHost).setDefaultCredentialsProvider(credentialsProvider).build();
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 * @throws Exception
	 */
	public byte[] sendGetRequest(String url) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		System.out.println("Send Get Request : " + url);
		return sendRequest(httpGet);
	}

	/**
	 * 发送post 请求
	 * 
	 * @param request
	 * @throws Exception
	 */
	@Test
	public byte[] sendPostRequest(String url, Map<String, String> params) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		// 设置参数
		if (params != null && params.size() > 0) {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Entry<String, String> param : params.entrySet()) {
				nvps.add(new BasicNameValuePair(param.getKey(), param.getValue()));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		}

		System.out.println("Send Post Request : " + url + " , " + params);
		return sendRequest(httpPost);
	}

	// 底层请求打印页面
	private byte[] sendRequest(HttpRequestBase request) throws Exception {
		CloseableHttpResponse response = httpclient.execute(request);

		// 设置超时
		setTimeOut(request, 5000);

		// 获取返回的状态列表
		StatusLine statusLine = response.getStatusLine();
		System.out.println("StatusLine : " + statusLine);

		if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
			try {
				// 获取response entity
				HttpEntity entity = response.getEntity();
				System.out.println("getContentType ： " + entity.getContentType().getValue());
				System.out.println("getContentEncoding ： " + entity.getContentEncoding().getValue());

				// 读取响应内容
				byte[] responseBody = EntityUtils.toByteArray(entity);

				// 关闭响应流
				EntityUtils.consume(entity);
				return responseBody;
			} finally {
				response.close();
			}
		}
		return null;
	}

	// 设置超时重定向
	private void setTimeOut(HttpRequestBase request, int timeout) {
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeout)
				.setConnectTimeout(timeout).setSocketTimeout(timeout).setRedirectsEnabled(true).build();
		request.setConfig(requestConfig);
	}

	/**
	 * 设置全局Cookies
	 * 
	 * @param cookies
	 * @return
	 */
	public HttpClient setGlobeCookieHttpClient(Map<String, String> cookies) {
		HttpClient client = null;
		if (cookies != null && cookies.size() > 0) {
			BasicCookieStore cookieStore = new BasicCookieStore();

			for (Entry<String, String> c : cookies.entrySet()) {
				BasicClientCookie cookie = new BasicClientCookie(c.getKey(), c.getValue());
				cookie.setDomain("sina.com");
				cookie.setPath("/");
				cookieStore.addCookie(cookie);
			}
			client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
		} else {
			client = HttpClients.createDefault();
		}
		return client;
	}

	/**
	 * 设置Cookie方法1
	 * 
	 * @param request
	 * @param cookies
	 */
	public void setRequestCookiesStr(HttpUriRequest request, Map<String, String> cookies) {
		StringBuilder cookieStr = new StringBuilder();
		if (cookies != null && cookies.size() > 0) {
			for (Entry<String, String> cookie : cookies.entrySet()) {
				cookieStr.append(cookie.getKey()).append('=').append(cookie.getValue()).append(';');
			}
			cookieStr.deleteCharAt(cookieStr.length() - 1);
			request.addHeader("Cookie", cookieStr.toString());
		}
	}

	/**
	 * 设置Cookie 方法2
	 * 
	 * httpclient.execute(request, context) 方法进行添加
	 * 
	 * @param cookies
	 * @return
	 */
	public HttpContext getetRequestCookieContext(Map<String, String> cookies) {
		HttpContext localContext = null;
		if (cookies != null && cookies.size() > 0) {
			BasicCookieStore cookieStore = new BasicCookieStore();

			for (Entry<String, String> c : cookies.entrySet()) {
				BasicClientCookie cookie = new BasicClientCookie(c.getKey(), c.getValue());
				cookie.setDomain("sina.com");
				cookie.setPath("/");
				cookieStore.addCookie(cookie);
			}
			localContext = new BasicHttpContext();
			localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
		}
		return localContext;
	}

	/**
	 * 响应中获取cookie
	 * 
	 * @param response
	 */
	public void getResponseCookies(HttpResponse response) {
		// 法1
		HeaderIterator headerIter = response.headerIterator("Set-Cookie");
		while (headerIter.hasNext()) {
			Object obj = headerIter.next();
			if (obj != null) {
				String cookie = ((Header) headerIter.next()).getValue();

				String cookieRecord = cookie.substring(0, cookie.indexOf(';'));
				System.out.println(cookieRecord);
			}

		}

		// 法2
		HeaderElementIterator headerElementIter = new BasicHeaderElementIterator(response.headerIterator("Set-Cookie"));
		while (headerElementIter.hasNext()) {
			HeaderElement elem = headerElementIter.nextElement();
			System.out.println("Element : " + elem.getName() + " = " + elem.getValue());
			NameValuePair[] params = elem.getParameters();
			for (int i = 0; i < params.length; i++) {
				System.out.println(" Params : " + params[i].getName() + " | " + params[i].getValue());
			}
		}
	}

	public void shutdown() throws Exception {
		httpclient.close();
	}

	public static void main(String[] args) throws Exception {
		String url = "http://www.google.com.hk";

		HTCtest httpclient = new HTCtest();

		byte[] getResponse = httpclient.sendGetRequest(url);
		System.out.println("Get Body : " + new String(getResponse, "utf-8"));

		byte[] postResponse = httpclient.sendPostRequest(url, null);
		System.out.println("Get Body : " + new String(postResponse, "utf-8"));

		httpclient.shutdown();
	}
}
