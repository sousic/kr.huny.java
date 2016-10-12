package kr.huny.service;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.ArticlesVO;
import kr.huny.persistence.board.ArticlesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by sousic on 2016-10-12.
 */
@Service
public class ArticlesServiceImpl implements ArticlesService {
    @Autowired
    private ArticlesDAO articlesDAO;

    @Override
    public int articlesListCount(PageInfo pageInfo) throws Exception {
        return articlesDAO.articlesListCount(pageInfo);
    }

    @Override
    public Collection<? extends ArticlesVO> articlesListNotice() throws Exception {
        return articlesDAO.articlesListNotice();
    }

    @Override
    public Collection<? extends ArticlesVO> articlesList(PageInfo pageInfo) throws Exception {
        return articlesDAO.articlesList(pageInfo);
    }

    @Override
    public void articleCreate(ArticlesVO articlesVO) throws Exception {
        articlesDAO.articleCreate(articlesVO);
    }

    @Override
    public ArticlesVO articleView(ArticlesVO articlesVO) throws Exception {
        return articlesDAO.articleView(articlesVO);
    }

    @Override
    public void articleModify(ArticlesVO articlesVO) throws Exception {
        articlesDAO.articleModify(articlesVO);
    }

    @Override
    public void articleDelete(ArticlesVO articlesVO) throws Exception {
        articlesDAO.articleDelete(articlesVO);
    }
}
