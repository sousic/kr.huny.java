package kr.huny.persistence;

import kr.huny.domain.MembersVO;
import kr.huny.dto.LoginDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.lang.reflect.Member;

/**
 * Created by dhjang on 2016-08-22.
 */
@Repository
public class MembersDAOImpl implements MembersDAO {
    @Inject
    private SqlSession sqlSession;
    private static String namespace = "kr.huny.persistence.MembersDAO";

    @Override
    public MembersVO login(LoginDTO loginDTO) throws Exception {
        return sqlSession.selectOne(namespace + ".login", loginDTO);
    }
}
