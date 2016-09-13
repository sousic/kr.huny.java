package kr.huny.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.huny.domain.member.MembersVO;
import kr.huny.dto.SessionAdminDTO;
import kr.huny.dto.SessionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * Created by sousic on 2016. 9. 4..
 */
public class CookieHelper {

    private final Logger logger = LoggerFactory.getLogger(CookieHelper.class);

    public static void SetLoginSessionAdmin(MembersVO membersVO, HttpServletResponse response, PropertyHelper propertyHelper)
    {
        SessionAdminDTO sessionAdminDTO = new SessionAdminDTO();
        sessionAdminDTO.setUserid(membersVO.getUserid());
        sessionAdminDTO.setNickname(membersVO.getNickname());

        ObjectMapper objectMapper = new ObjectMapper();
        String strSessionDTO = null;
        try {
            strSessionDTO = objectMapper.writeValueAsString(sessionAdminDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        MakeCookies(response, propertyHelper.getAESSecretKey(), propertyHelper.getCookieNameAdmin(), strSessionDTO);
    }

    public static void SetLoginSession(MembersVO membersVO, HttpServletResponse response, PropertyHelper propertyHelper) {
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setUserid(membersVO.getUserid());
        sessionDTO.setNickname(membersVO.getNickname());

        ObjectMapper objectMapper = new ObjectMapper();
        String strSessionDTO = null;
        try {
            strSessionDTO = objectMapper.writeValueAsString(sessionDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        MakeCookies(response, propertyHelper.getAESSecretKey(), propertyHelper.getCookieName(), strSessionDTO);
    }

    /**
     * 쿠키 생성
     * @param response
     * @param AESSecretKey - 암호화 키
     * @param cookieName - 쿠키명
     * @param strSessionInfo - 쿠키내역
     */
    private static void MakeCookies(HttpServletResponse response, String AESSecretKey, String cookieName, String strSessionInfo) {
        AES256Helper aes256Helper = null;
        try {
            aes256Helper = new AES256Helper(AESSecretKey);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String strEncSessionDTO = null;
        try {
            strEncSessionDTO = aes256Helper.encrypt(strSessionInfo);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Cookie cookie = new Cookie(cookieName, strEncSessionDTO);
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
    }

    public static SessionDTO LoginSession(HttpServletRequest request, PropertyHelper propertyHelper) {
        SessionDTO sessionDTO = null;
        AES256Helper aes256Helper = null;

        Cookie cookie = WebUtils.getCookie(request, propertyHelper.getCookieName());

        if(cookie != null) {
            try {
                aes256Helper = new AES256Helper(propertyHelper.getAESSecretKey());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String strDecSession = cookie.getValue();
            if(!StringUtils.isEmpty(strDecSession)) {
                try {
                    strDecSession = aes256Helper.decrpyt(strDecSession);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    sessionDTO = objectMapper.readValue(strDecSession, SessionDTO.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sessionDTO;
    }

    public static SessionAdminDTO LoginSessionAdmin(HttpServletRequest request, PropertyHelper propertyHelper) {
        SessionAdminDTO sessionAdminDTO = null;
        AES256Helper aes256Helper = null;

        Cookie cookie = WebUtils.getCookie(request, propertyHelper.getCookieNameAdmin());

        if(cookie != null) {
            try {
                aes256Helper = new AES256Helper(propertyHelper.getAESSecretKey());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String strDecSession = cookie.getValue();
            if(!StringUtils.isEmpty(strDecSession)) {
                try {
                    strDecSession = aes256Helper.decrpyt(strDecSession);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    sessionAdminDTO = objectMapper.readValue(strDecSession, SessionAdminDTO.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sessionAdminDTO;
    }

    public static String NickName(PropertyHelper propertyHelper) {
        SessionAdminDTO sessionAdminDTO = LoginSessionAdmin(getRequest(), propertyHelper);

        return sessionAdminDTO.getNickname();
    }

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
