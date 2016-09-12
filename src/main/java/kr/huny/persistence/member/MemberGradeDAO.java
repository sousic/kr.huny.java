package kr.huny.persistence.member;

import kr.huny.domain.member.MemberGradeVO;

/**
 * Created by sousic on 2016-09-12.
 */
public interface MemberGradeDAO {
    public void UpdateMemberGradeCount(int grade) throws Exception;
    public MemberGradeVO SelectmemberGrade(int grade) throws Exception;
}
