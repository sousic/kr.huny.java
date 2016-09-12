package kr.huny.domain.member;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by sousic on 2016-09-12.
 */
@Data
public class LoginHistoryVO {
    private long seq;
    private String userid;
    private String remoteip;
    private Date date;
    private String result;
    private short flag;
}
