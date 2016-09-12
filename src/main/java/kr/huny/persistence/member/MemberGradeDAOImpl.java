package kr.huny.persistence.member;

import kr.huny.domain.member.MemberGradeVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * Created by sousic on 2016-09-12.
 */
@Repository
public class MemberGradeDAOImpl implements MemberGradeDAO {

    @Inject
    private SqlSession sqlSession;
    private final String namespace = "kr.huny.persistence.member.MemberGradeDAO";

    @Override
    public void UpdateMemberGradeCount(int grade) throws Exception {
        sqlSession.update(namespace+".UpdateMemberGradeCount", grade);
    }

    @Override
    public MemberGradeVO SelectmemberGrade(int grade) throws Exception {
        return sqlSession.selectOne(namespace+".SelectmemberGrade", grade);
    }
}
