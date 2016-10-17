package kr.huny.domain.board;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by sousic on 2016-10-04.
 */
@Data
public class ArticlesVO {
    private long seq;
    private long bm_seq;
    private String title;
    private String contents;
    private String writer;
    private Date createdate;
    private Date modifydate;
    private Date deletedate;
    private Boolean isNotice;
    private Boolean isComment;
    private Boolean isDelete;
    private int attachmentCount;
    private int readCount;

    private BoardManagerVO boardManagerVO;

    private List<AttachmentsVO> attachments;
}
