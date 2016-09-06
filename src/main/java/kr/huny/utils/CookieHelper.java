package kr.huny.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.huny.domain.MembersVO;
import kr.huny.dto.SessionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

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

        AES256Helper aes256Helper = null;
        try {
            aes256Helper = new AES256Helper(propertyHelper.getAESSecretKey());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String strEncSessionDTO = null;
        try {
            strEncSessionDTO = aes256Helper.encrypt(strSessionDTO);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Cookie cookie = new Cookie(propertyHelper.getCookieName(), strEncSessionDTO);
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
}
