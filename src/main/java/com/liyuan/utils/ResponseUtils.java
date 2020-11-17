package com.liyuan.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtils {
    public static String build(int status, String message, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", System.currentTimeMillis());
        map.put("code", status);
        map.put("message", message);
        map.put("data", data);
        return JSONObject.toJSONString(map);
    }

    public static String build(int status, String message) {
        return build(status, message, null);
    }

    public static void printJson(HttpServletResponse response, String data) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(data);
        printWriter.close();

    }

}
