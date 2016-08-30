package kr.huny.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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
}
