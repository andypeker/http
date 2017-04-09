package hw.util.http;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpRequest {

    //http客户端  
    public static DefaultHttpClient httpClient;

    static {
        httpClient = new DefaultHttpClient();
    }

    public enum HttpMethod {
                            HTTP_GET(0), HTTP_POST(1);
        private final int value;

        HttpMethod(int v) {
            value = v;
        }

        public int value() {
            return value;
        }

        public static HttpMethod fromValue(int v) {
            for (HttpMethod c : HttpMethod.values()) {
                if (c.value == v) {
                    return c;
                }
            }
            throw new IllegalArgumentException(String.valueOf(v));
        }
    };

    /** 
     * http get
     */
    public static String doHttpGet(String httpUrl) throws Exception {
        HttpGet httpGet = HttpClientConnectionManager.getGetMethod(httpUrl);
        HttpResponse response = httpClient.execute(httpGet);
        String str = EntityUtils.toString(response.getEntity(), "UTF-8");
        return str;
    }

    /** 
     * http post
     */
    public static String doHttpPost(String httpsUrl, Header header, List<NameValuePair> nvps) throws Exception {
        HttpPost httpPost = HttpClientConnectionManager.getPostMethod(httpsUrl);
        httpPost.setHeader(header);
        if (nvps != null && nvps.size() > 0) {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        }
        Header h1 = httpPost.getFirstHeader("token");
        String token = "";
        if (h1 != null) {
            token = h1.toString();
        }
        Header h2 = httpPost.getFirstHeader("rid");
        String rid = "";
        if (h2 != null) {
            rid = h2.toString();
        }
        System.out.println("请求：\nmethod: " + httpPost.getMethod() + "\nurl: " + httpPost.getURI().toURL().toString() + "\nheaders: " + token + "; rid：" + rid
                           + "\nparams: " + EntityUtils.toString(httpPost.getEntity(), "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
        String str = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println("应答报文：\n" + str);
        return str;
    }
}
