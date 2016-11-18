package kr.huny.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by sousic on 2016-11-18.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int seq;
    private String code;
    private short writable;
    private short enabled;
    private int level;
    private int sortOrder;
    private String parentCode;
    private Date createDate;
    private Date lastUpdate;
}
