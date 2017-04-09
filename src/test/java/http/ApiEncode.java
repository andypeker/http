/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package http;

import org.bouncycastle.util.encoders.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author fanggang
 * @version $Id: ApiEncode.java, v 0.1 2016年7月28日 下午5:25:44 fanggang Exp $
 */
public class ApiEncode {

    public static String doEncode(JSONObject jsonObject) {
        String str = JSON.toJSONString(jsonObject);
        String enUrl = new String(Base64.encode(str.getBytes()));
        return enUrl;
    }
}
