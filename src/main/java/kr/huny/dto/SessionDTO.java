package kr.huny.dto;

import kr.huny.domain.db.User;
import lombok.Data;

/**
 * Created by sousic on 2016. 9. 4.
 * 기본 세션 빈
 */
@Data
public class SessionDTO {
    private String userid;
    private String nickname;
    private int grade;

    public void SessionCopy(User user)
    {
        this.userid = user.getUserid();
        this.nickname = user.getName();
        this.grade = user.getGrade();
    }
}
