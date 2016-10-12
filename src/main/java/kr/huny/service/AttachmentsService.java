package kr.huny.service;

import kr.huny.domain.board.AttachmentsVO;

/**
 * Created by sousic on 2016-10-12.
 */
public interface AttachmentsService {
    public void insertAttachments(AttachmentsVO attachmentsVO) throws Exception;
    public AttachmentsVO selectAttachments(AttachmentsVO attachmentsVO) throws Exception;
    public void updateAttachments(AttachmentsVO attachmentsVO) throws Exception;
    public void deleteAttachments(AttachmentsVO attachmentsVO) throws Exception;
}
