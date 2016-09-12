package kr.huny.persistence.member;

import kr.huny.domain.member.MembersVO;
import kr.huny.dto.LoginDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * Created by dhjang on 2016-08-22.
 */
@Repository
public class MembersDAOImpl implements MembersDAO {
    @Inject
    private SqlSession sqlSession;
    private final static String namespace = "kr.huny.persistence.member.MembersDAO";

    @Override
    public MembersVO login(LoginDTO loginDTO) throws Exception {
        return sqlSession.selectOne(namespace + ".login", loginDTO);
    }

    @Override
    public MembersVO idChecker(String userid) throws Exception {
        return sqlSession.selectOne(namespace + ".idChecker", userid);
    }

    @Override
    public void register(MembersVO membersVO) throws Exception {
        sqlSession.insert(namespace + ".register", membersVO);
    }

    @Override
    public void UpdatePwdFailCount(MembersVO membersVO) {
        sqlSession.update(namespace + ".UpdatePwdFailCount", membersVO);
    }
}
