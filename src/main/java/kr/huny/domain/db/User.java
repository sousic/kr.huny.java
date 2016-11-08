package kr.huny.domain.db;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by sousic on 2016-11-04.
 */
@Data
@Builder
public class User {
    private long seq;
    private String userid;
    private String password;
    private String name;
    private Date reg_date;
}
