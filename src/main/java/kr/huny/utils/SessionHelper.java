package kr.huny.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.huny.domain.MembersVO;
import kr.huny.dto.SessionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * Created by sousic on 2016. 9. 4..
 */
@Service
public class SessionHelper {
    private final Logger logger = LoggerFactory.getLogger(SessionHelper.class);

    @Resource
    private PropertyHelper propertyHelper;
    private SessionDTO sessionDTO;
    private AES256Helper aes256Helper;

    public void SetLoginSession(MembersVO membersVO, HttpServletResponse response) throws UnsupportedEncodingException, JsonProcessingException, GeneralSecurityException {
        sessionDTO = new SessionDTO();
        sessionDTO.setUserid(membersVO.getUserid());
        sessionDTO.setNickname(membersVO.getNickname());

        ObjectMapper objectMapper = new ObjectMapper();
        String strSessionDTO = objectMapper.writeValueAsString(sessionDTO);

        aes256Helper = new AES256Helper(propertyHelper.getAESSecretKey());
        String strEncSessionDTO = aes256Helper.encrypt(strSessionDTO);

        Cookie cookie = new Cookie(propertyHelper.getCookieName(), strEncSessionDTO);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public SessionDTO LoginSession(String strEncSessionDTO) throws GeneralSecurityException, IOException {
        SessionDTO sessionDTO = null;

        String strDecSession = aes256Helper.decrpyt(strEncSessionDTO);
        logger.info("LoginSession : " + strEncSessionDTO);
        logger.info("LoginSession : " + strDecSession);
        ObjectMapper objectMapper = new ObjectMapper();
        sessionDTO = objectMapper.readValue(strDecSession, SessionDTO.class);

        return sessionDTO;
    }
}
