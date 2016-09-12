package kr.huny.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sousic on 2016-09-12.
 */
public class RequestHelper {
    public static String remoteIP(HttpServletRequest request)
    {
        String ip = request.getHeader("X-FORWARDED-FOR");
        if(ip == null) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
