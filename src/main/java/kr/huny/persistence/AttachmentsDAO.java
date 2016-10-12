package kr.huny.persistence;

import kr.huny.domain.board.AttachmentsVO;

import java.util.List;
/**
 * Created by sousic on 2016-10-12.
 */
public interface AttachmentsDAO {
    public void insertAttachments(AttachmentsVO attachmentsVO) throws Exception;
    public AttachmentsVO readAttachments(AttachmentsVO attachmentsVO) throws Exception;
    public void updateAttachments(AttachmentsVO attachmentsVO) throws Exception;
    public List<AttachmentsVO> selectAttachemtnsList(AttachmentsVO attachmentsVO) throws Exception;
}
