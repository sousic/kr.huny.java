package kr.huny.dto;

import lombok.Data;

/**
 * Created by dhjang on 2016-08-22.
 */
@Data
public class LoginDTO {
    private String userid;
    private String userpwd;
    private boolean remember;
    private String nickname;
    private int pwdfailcntLimit;

    private int grade;
    private boolean isAdmin;
}
