package org.smartx.summer.common;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ming on 2016/11/24.
 */
public final class IpUtils {

    public static String getRemoteIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP") == null ? null
                : request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for") == null ? null
                    : request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP") == null ? null
                    : request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP") == null ? null
                    : request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
