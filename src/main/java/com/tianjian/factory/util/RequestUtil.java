package com.tianjian.factory.util;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by tianjian on 2020/3/24.
 */
public class RequestUtil {
    public static String getUserCodeBySession(HttpServletRequest request) {
        return (String) request.getHeader("userid");
    }
}
