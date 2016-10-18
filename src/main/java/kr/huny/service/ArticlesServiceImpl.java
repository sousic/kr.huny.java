package kr.huny.service;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.ArticlesVO;
import kr.huny.domain.board.AttachmentsVO;
import kr.huny.persistence.AttachmentsDAO;
import kr.huny.persistence.board.ArticlesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by sousic on 2016-10-12.
 */
@Service
public class ArticlesServiceImpl implements ArticlesService {

    @Autowired
    private ArticlesDAO articlesDAO;
    @Autowired
    private AttachmentsDAO attachmentsDAO;

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

    @Transactional
    @Override
    public void articleCreate(ArticlesVO articlesVO) throws Exception {
        articlesDAO.articleCreate(articlesVO);
        attachmentsUpdate(articlesVO);

        updateArticleAttachmentCount(articlesVO);
    }

    @Override
    public ArticlesVO articleView(ArticlesVO articlesVO) throws Exception {
        return articlesDAO.articleView(articlesVO);
    }

    @Transactional
    @Override
    public void articleModify(ArticlesVO articlesVO) throws Exception {
        articlesDAO.articleModify(articlesVO);
        attachmentsUpdate(articlesVO);

        updateArticleAttachmentCount(articlesVO);
    }

    private void updateArticleAttachmentCount(ArticlesVO articlesVO) throws Exception {
        AttachmentsVO attachmentsVO = new AttachmentsVO();
        attachmentsVO.setBm_seq(articlesVO.getBm_seq());
        attachmentsVO.setA_seq(articlesVO.getSeq());
        articlesVO.setAttachmentCount(attachmentsDAO.selectAttachmentsCount(attachmentsVO));
        articlesDAO.updateAttachmentsCount(articlesVO);
    }

    private void attachmentsUpdate(ArticlesVO articlesVO) throws Exception {
        if(articlesVO.getAttachments() != null) {
            for (AttachmentsVO attachmentsVO : articlesVO.getAttachments()) {
                attachmentsVO.setA_seq(articlesVO.getSeq());
                attachmentsVO.setBm_seq(articlesVO.getBm_seq());
                attachmentsDAO.updateAttachments(attachmentsVO);
            }
        }
    }

    @Override
    public void articleDelete(ArticlesVO articlesVO) throws Exception {
        articlesDAO.articleDelete(articlesVO);
    }

    @Override
    public void updateAttachmentsCount(ArticlesVO articlesVO) throws Exception {
        articlesDAO.updateAttachmentsCount(articlesVO);
    }
}
