package kr.huny.persistence.board;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.ArticlesVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by sousic on 2016-10-04.
 */
@Repository
public class ArticlesDAOImpl implements ArticlesDAO {

    @Inject
    private SqlSession sqlSession;

    private final String namespace = "kr.huny.persistence.board.ArticlesDAO";

    @Override
    public int articlesListCount(PageInfo pageInfo) throws Exception {
        return sqlSession.selectOne(namespace + ".articlesListCount", pageInfo);
    }

    @Override
    public List<ArticlesVO> articlesList(PageInfo pageInfo) throws Exception {
        return sqlSession.selectList(namespace +".articlesList", pageInfo);
    }

    @Override
    public void articleCreate(ArticlesVO articlesVO) throws Exception {
        throw new Exception();
        //sqlSession.insert(namespace + ".articleCreate", articlesVO);
    }

    @Override
    public void articleModify(ArticlesVO articlesVO) throws Exception {
        sqlSession.update(namespace +".articleModify", articlesVO);
    }

    @Override
    public void articleDelete(ArticlesVO articlesVO) throws Exception {
        sqlSession.update(namespace + ".articleDelete", articlesVO);
    }
}
