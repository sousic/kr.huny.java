package kr.huny.service;

import kr.huny.domain.board.AttachmentsVO;
import kr.huny.persistence.AttachmentsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sousic on 2016-10-12.
 */
@Service
public class AttachmentsServiceImpl implements AttachmentsService {
    @Autowired
    private AttachmentsDAO attachmentsDAO;

    @Override
    public void insertAttachments(AttachmentsVO attachmentsVO) throws Exception {
        attachmentsDAO.insertAttachments(attachmentsVO);
    }

    @Override
    public AttachmentsVO selectAttachments(AttachmentsVO attachmentsVO) throws Exception {
        return attachmentsDAO.readAttachments(attachmentsVO);
    }

    @Override
    public void updateAttachments(AttachmentsVO attachmentsVO) throws Exception {
        attachmentsDAO.updateAttachments(attachmentsVO);
    }

    @Override
    public void deleteAttachments(AttachmentsVO attachmentsVO) throws Exception {
        attachmentsDAO.deleteAttachments(attachmentsVO);
    }
}
