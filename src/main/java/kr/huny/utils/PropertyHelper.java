package kr.huny.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sousic on 2016-08-30.
 */
@Getter
@Component
public class PropertyHelper {
    @Value("#{prop['loginFailLimitCount']}")
    private int loginFailLimitCount;

    @Value("#{prop['aes.secretkey']}")
    private String AESSecretKey;

    @Value("#{prop['cookie.name']}")
    private String cookieName;

    @Value("#{prop['register.member.grade']}")
    private int registerMemberGrade;

    @Value("#{prop['signin.logging']}")
    private boolean SigninLogging;

    @Value("#{prop['cookie.name.admin']}")
    private String cookieNameAdmin;
}
