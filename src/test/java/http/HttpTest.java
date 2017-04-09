/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSONObject;

import hw.util.http.HttpRequest;

/**
 * 
 * @author pengliqing
 * @version $Id: HttpTest.java, v 0.1 2016年7月5日 上午10:40:31 pengliqing Exp $
 */
public class HttpTest {

    private static final String URL   = "http://10.0.6.2:8888/appapi/";
    //    private static final String URL   = "http://127.0.0.1:8080/appapi/";

    //    private static final String token = "3338bde1a96036d8aeb846d70ec1a5ce";
    //    private static final String token = "4916e7e2c8da64630b5bd533185635e3";
    //    private static final String token = "4d20d469738ecd7783467eb4ce0178ad";  
    private static final String token = "a5a34d74d1051a601f232de04c705c48";
    private static final String rid   = "2216619736564957";

    public static void main(String[] args) throws Exception {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Header header = new BasicHeader("token", token);
        Header header2 = new BasicHeader("rid", rid);
        //        findCheckingDetail(header, nvps);
        //        findCheckings(header, nvps);
        //        confirmChecking(header, nvps);
        //        accountBalance(header, nvps);
        //        monthlySales(header, nvps);
        //        findOftenlyPurchased(header, nvps);
        //        search(header, nvps);
        //        hotwords(header, nvps);
        //                sendCodeWithMobile(header, nvps);
        //        login(header, nvps);
        //        saveOrder(header, nvps);

        //        getSpuForOrder(header, nvps);

        //        getOrdersByReseller(header, nvps);
        //        findOrdersByPhoneNum(header, nvps);
        //        findOrderDetailByPhoneNum(header, nvps);
        getOrderDetailByReseller(header, nvps);
        //        sendCodeWithMobile(header, nvps);
        //        checkCode(header, nvps);
    }

    public static void saveOrder(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject order = new JSONObject();
        order.put("buyDate", "2016-08-19");
        order.put("cPaidAmount", "2.000000");
        order.put("channelId", "2216619741563734");
        order.put("contactMobile", "13430664102");
        order.put("contactee", "张三");
        order.put("groupin", "0");
        order.put("method", "saveOrder");
        order.put("productInfoId", "2216619741563867");
        order.put("scienicId", "2216619741563754");
        order.put("supplierId", "2216619741564022");

        JSONObject ticket1 = new JSONObject();
        ticket1.put("buyCard", "110105197203163585");
        ticket1.put("buyName", "王五");
        ticket1.put("channelId", "2216619741563734");
        ticket1.put("price", "1");
        ticket1.put("productId", "2216619741564052");
        ticket1.put("strategyId", "2216619741564335");
        ticket1.put("supplierId", "2216619741564022");
        JSONObject ticket2 = new JSONObject();
        ticket2.put("buyCard", "110104200804169980");
        ticket2.put("buyName", "周七");
        ticket2.put("channelId", "2216619741563734");
        ticket2.put("price", "1");
        ticket2.put("productId", "2216619741564052");
        ticket2.put("strategyId", "2216619741564335");
        ticket2.put("supplierId", "2216619741564022");

        JSONObject[] tickets = { ticket1, ticket2 };
        order.put("tickets", tickets);

        String data = ApiEncode.doEncode(order);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "bapi", header, nvps);
    }

    public static void testBapi(Header header, List<NameValuePair> nvps) throws Exception {
        nvps.add(new BasicNameValuePair("data", "eyJjdXJyZW50UGFnZSI6MSwicGFnZVNpemUiOjEwfQ=="));
        nvps.add(new BasicNameValuePair("sign", "secret"));
        HttpRequest.doHttpPost(URL + "bapi", header, nvps);
    }

    public static void updateUserInfo(Header header, List<NameValuePair> nvps) throws Exception {
        String data = "eyJpZGVudGlmeVR5cGUiOiJwIiwidHlwZSI6MH0=";
        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "user/updateCustomerInfo", header, nvps);

    }

    public static void findCheckingDetail(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 2216619736563723l);
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "wallet/checkingDetail", header, nvps);
    }

    public static void findCheckings(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNO", 1);
        jsonObject.put("pageSize", 3);
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "wallet/myCheckings", header, nvps);
    }

    public static void confirmChecking(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 2216619736563723l);
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "wallet/checkingConfirm", header, nvps);
    }

    public static void accountBalance(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "wallet/accountBalance", header, nvps);
    }

    public static void monthlySales(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "wallet/monthlySales", header, nvps);
    }

    public static void findOftenlyPurchased(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNO", 1);
        jsonObject.put("pageSize", 3);
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "wallet/oftenlyPurchased", header, nvps);
    }

    public static void search(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");

        jsonObject.put("salesType", "4");
        jsonObject.put("productName", "北京");
        jsonObject.put("province", "");
        jsonObject.put("city", "");
        jsonObject.put("county", "");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "product/search", header, nvps);
    }

    public static void hotwords(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "product/hotwords", header, nvps);
    }

    public static void sendCodeWithMobile(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("method", "sendCodeWithMobile");
        //        jsonObject.put("loginName", "");
        jsonObject.put("tel", "18655406838");
        jsonObject.put("type", "2");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, "")));
        HttpRequest.doHttpPost(URL + "bapi", header, nvps);
    }

    public static void checkCode(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("method", "checkCode");
        jsonObject.put("mobile", "18655406838");
        jsonObject.put("code", "327175");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, "")));
        HttpRequest.doHttpPost(URL + "bapi", header, nvps);
    }

    public static void login(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");
        jsonObject.put("username", "qqwweerr");
        jsonObject.put("password", "123456");
        jsonObject.put("type", "1");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "user/login", header, nvps);
    }

    public static void getOrdersByReseller(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");
        jsonObject.put("currentPage", 1);
        jsonObject.put("pageSize", "3");
        jsonObject.put("category", "");
        jsonObject.put("orderState", "");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "order/getOrdersByReseller", header, nvps);
    }

    public static void findOrdersByPhoneNum(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");
        jsonObject.put("currentPage", 1);
        jsonObject.put("pageSize", "3");
        jsonObject.put("category", "");
        jsonObject.put("orderState", "");
        jsonObject.put("contactMobile", "15941411111");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, "")));
        HttpRequest.doHttpPost(URL + "order/findOrdersByPhoneNum", header, nvps);
    }

    public static void getOrderDetailByReseller(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");
        jsonObject.put("orderId", "MF970264625");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "order/getOrderDetailByReseller", header, nvps);
    }

    public static void findOrderDetailByPhoneNum(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");
        jsonObject.put("orderId", "MF483209572");
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, "")));
        HttpRequest.doHttpPost(URL + "order/findOrderDetailByPhoneNum", header, nvps);
    }

    // 查询产品组信息（下单页面）
    public static void getSpuForOrder(Header header, List<NameValuePair> nvps) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "1.0.0");
        jsonObject.put("id", "2216619736567077"); // 产品或产品组ID
        jsonObject.put("idType", "1"); // 1 产品；2 产品组
        jsonObject.put("salesType", "5"); // 商户
        String data = ApiEncode.doEncode(jsonObject);

        nvps.add(new BasicNameValuePair("data", data));
        nvps.add(new BasicNameValuePair("sign", ApiDecode.sign(data, token)));
        HttpRequest.doHttpPost(URL + "product/getSpuForOrder", header, nvps);
    }
}
