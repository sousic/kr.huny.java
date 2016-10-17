package kr.huny.domain.board;

import lombok.Data;

/**
 * Created by sousic on 2016-10-11.
 */
@Data
public class AttachmentsVO {
    private long seq;
    private long bm_seq;
    private long a_seq;
    private String filename;
    private long filesize;
    private int download;
    private String save_path;
    private String save_name;
    private String contentType;
    private Boolean isTemporary;
}
