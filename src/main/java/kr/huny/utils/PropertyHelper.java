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
    @Value("#{prop['aes.secretkey']}")
    private String AESSecretKey;

    @Value("#{prop['cookie.name']}")
    private String cookieName;

    @Value("#{prop['cookie.name.admin']}")
    private String cookieNameAdmin;

    @Value("#{prop['upload.path']}")
    private String uploadPath;
}
