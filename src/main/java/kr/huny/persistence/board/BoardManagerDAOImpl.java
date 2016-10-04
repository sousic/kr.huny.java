package kr.huny.persistence.board;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.BoardManagerVO;
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
    public List<BoardManagerVO> boardManagerList(PageInfo pageInfo) throws Exception {
        return sqlSession.selectList(namespace + ".boardManagerList", pageInfo);
    }

    @Override
    public int boardManagerListCount(PageInfo pageInfo) throws Exception {
        return sqlSession.selectOne(namespace + ".boardManagerListCount", pageInfo);
    }

    @Override
    public void insertBoardManager(BoardManagerVO boardManagerVO) throws Exception {
        sqlSession.insert(namespace + ".insertBoardManager", boardManagerVO);
    }

    @Override
    public BoardManagerVO readBoardManager(int seq) throws Exception {
        return sqlSession.selectOne(namespace + ".readBoardManager", seq);
    }

    @Override
    public void updateBoardManager(BoardManagerVO boardManagerVO) throws Exception {
        sqlSession.update(namespace + ".updateBoardManager", boardManagerVO);
    }

    @Override
    public String GetBoardIdToTitle(long bm_seq) throws Exception {
        return sqlSession.selectOne(namespace + ".GetBoardIdToTitle", bm_seq);
    }
}
