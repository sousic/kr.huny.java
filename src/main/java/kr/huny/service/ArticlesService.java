package kr.huny.service;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.ArticlesVO;

import java.util.Collection;

/**
 * Created by sousic on 2016-10-12.
 */
public interface ArticlesService {
    public int articlesListCount(PageInfo pageInfo) throws Exception;
    public Collection<? extends ArticlesVO> articlesListNotice() throws Exception;
    public Collection<? extends ArticlesVO> articlesList(PageInfo pageInfo) throws Exception;
    public void articleCreate(ArticlesVO articlesVO) throws Exception;
    public ArticlesVO articleView(ArticlesVO articlesVO) throws Exception;
    public void articleModify(ArticlesVO articlesVO) throws Exception;
    public void articleDelete(ArticlesVO articlesVO) throws Exception;

    public void updateAttachmentsCount(ArticlesVO articlesVO) throws Exception;
}
