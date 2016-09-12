package kr.huny.persistence.member;

import kr.huny.domain.member.LoginHistoryVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * Created by sousic on 2016-09-12.
 */
@Repository
public class LoginHistoryDAOImpl implements LoginHistoryDAO {
    @Inject
    private SqlSession sqlSession;
    private final static String namespace = "kr.huny.persistence.member.LoginHistoryDAO";

    @Override
    public void InsertLoginHisotry(LoginHistoryVO loginHistoryVO) throws Exception {
        sqlSession.insert(namespace + ".InsertLoginHisotry", loginHistoryVO);
    }
}
