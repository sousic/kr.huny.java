package kr.huny.utils.session;

import kr.huny.dto.SessionDTO;
import kr.huny.utils.CookieHelper;
import kr.huny.utils.PropertyHelper;
import kr.huny.utils.RequestHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sousic on 2016-11-29.
 */
@Slf4j
@Component
public class LoginSession {

    @Autowired
    PropertyHelper propertyHelper;

    /**
     * 회원 등급
     * @return
     */
    public String UserGrade()
    {
        GetSessionDTO();
        return GetSessionDTO() == null ? null : GetSessionDTO().getGrade() + "";
    }

    /**
     * 회원 이름
     * @return
     */
    public String NickName()
    {
        GetSessionDTO();
        return GetSessionDTO() == null ? null : GetSessionDTO().getNickname();
    }

    /**
     * 로그인 유무
     * @return
     */
    public Boolean IsLoginSession()
    {
        return GetSessionDTO() == null ? false : true;
    }

    /**
     * 로그인 세션 객체 반환
     * @return
     */
    public SessionDTO GetSessionDTO()
    {
        return CookieHelper.LoginSession(RequestHelper.getCurrentRequest(), propertyHelper);
    }
}
