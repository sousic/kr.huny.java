package kr.huny.persistence;

import kr.huny.domain.db.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by sousic on 2016-11-04.
 */
@Slf4j
@Repository
public class UserDAOImpl implements UserDAO {

    private String namespace = "kr.huny.persistence.UserDAO";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public User findById(String userid) {
        return sqlSession.selectOne(namespace + ".findById", userid);
    }

    @Override
    public void joinUser(User user) {
        sqlSession.insert(namespace + ".joinUser", user);
    }
}
