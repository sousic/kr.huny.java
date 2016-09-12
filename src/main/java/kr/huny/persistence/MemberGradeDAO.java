package kr.huny.persistence;

import kr.huny.domain.MemberGradeVO;

/**
 * Created by sousic on 2016-09-12.
 */
public interface MemberGradeDAO {
    public void UpdateMemberGradeCount(int grade) throws Exception;
    public MemberGradeVO SelectmemberGrade(int grade) throws Exception;
}
