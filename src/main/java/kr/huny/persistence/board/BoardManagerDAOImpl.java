package kr.huny.persistence.board;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.BoardManageVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by sousic on 2016-09-27.
 */
@Repository
public class BoardManagerDAOImpl implements BoardManagerDAO
{
    @Inject
    private SqlSession sqlSession;

    private final static String namespace = "kr.huny.persistence.board.BoardManagerDAO";

    @Override
    public List<BoardManageVO> boardManagerList(PageInfo pageInfo) {
        return sqlSession.selectList(namespace + ".boardManagerList");
    }

    @Override
    public int boardManagerListCount(PageInfo pageInfo) {
        return sqlSession.selectOne(namespace + ".boardManagerListCount");
    }
}
