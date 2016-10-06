package kr.huny.domain.board;

import lombok.Data;

import java.util.Date;

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

    private BoardManagerVO boardManagerVO;
}
