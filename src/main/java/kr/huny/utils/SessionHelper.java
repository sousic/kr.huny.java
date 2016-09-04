package kr.huny.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.huny.domain.MembersVO;
import kr.huny.dto.SessionDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * Created by sousic on 2016. 9. 4..
 */
@Service
public class SessionHelper {
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
        response.addCookie(cookie);
    }
}
