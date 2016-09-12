package kr.huny.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by sousic on 2016-09-12.
 */
@Data
public class MemberGradeVO {
    private int seq;
    private String name;
    private String desc;
    private short grade;
    private int count;
    private Date regdate;
}
