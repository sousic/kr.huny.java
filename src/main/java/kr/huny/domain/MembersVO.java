package kr.huny.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by dhjang on 2016-08-22.
 */
@Data
public class MembersVO {
    private long seq;
    private String userid;
    private String userpwd;
    private String nickname;
    private short pwdfailcnt;
    private Date regdate;
    private Date lastlogindate;
    private short isloginblock;
    private int grade;
}

