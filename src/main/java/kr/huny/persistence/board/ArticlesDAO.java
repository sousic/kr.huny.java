package kr.huny.persistence.board;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.ArticlesVO;

import java.util.List;

/**
 * Created by sousic on 2016-10-04.
 */
public interface ArticlesDAO {
    public int articlesListCount(PageInfo pageInfo) throws Exception;
    public List<ArticlesVO> articlesList(PageInfo pageInfo) throws Exception;

    public void articleCreate(ArticlesVO articlesVO) throws Exception;
    public void articleModify(ArticlesVO articlesVO) throws Exception;
    public void articleDelete(ArticlesVO articlesVO) throws Exception;

    public ArticlesVO articleView(ArticlesVO articlesVO) throws Exception;

    public List<ArticlesVO> articlesListNotice() throws Exception;

    public void updateAttachmentsCount(ArticlesVO articlesVO) throws Exception;
}
