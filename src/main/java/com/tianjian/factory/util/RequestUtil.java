package com.tianjian.factory.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tianjian on 2020/3/24.
 */
public class RequestUtil {
    public static String getUserCodeBySession(HttpServletRequest request) {
        //String userCode = (String)request.getSession().getAttribute("openid");
        return "oYZkO5NQlnHowi5Y0lFFenQ4lMq8";
    }
}
