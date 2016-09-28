package kr.huny.domain.board;

import lombok.Data;

import java.util.Date;

/**
 * Created by sousic on 2016. 9. 8..
 */
@Data
public class BoardManageVO {
    private int seq;
    private String title;
    private String description;
    private long totalArticle;
    private Date createDate;
    private Date modifiyDate;
    private short displayType;
    private boolean isComment;
    private int listSize;
    private String writer;
    private boolean isArticleWriter;
}
