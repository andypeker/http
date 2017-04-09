/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package http;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.bouncycastle.util.encoders.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import hw.util.MD5Util;

/**
 * 
 * @author Mark
 * @version $Id: ApiDecode.java, v 0.1 2016年7月15日 下午1:28:08 pengliqing Exp $
 */
public class ApiDecode {

    public static void main(String[] args) throws Exception {

        JSONObject data = new JSONObject();
        //        data.put("orderState", 10);
        //        data.put("currentPage", "1");
        //        data.put("pageSize", "10");
        //        data.put("category", "");
        //        data.put("method", "queryOrdersByReseller");
        data.put("orderId", "MF1118631366");
        data.put("method", "queryOrderDetailByReseller");
        String str = JSON.toJSONString(data);
        String sdata = new String(Base64.encode(str.getBytes()));
        String token = "6473181c6ef2e4d87da9569eb115acee";
        String token2 = "473bfc41f149ab814094fbc6e1508ee9";
        System.out.println("data:" + sdata);
        System.out.println("sign:" + sign(sdata, token2));

        System.out.println(new String(Base64.decode(URLDecoder.decode(sdata, "UTF-8"))));

    }

    public static String sign(String data, String token) throws UnsupportedEncodingException {
        String sign = MD5Util.md5Hex(URLDecoder.decode(data, "UTF-8") + token);
        return sign;
    }
}
