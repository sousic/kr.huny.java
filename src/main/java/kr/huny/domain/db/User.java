package kr.huny.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by sousic on 2016-11-04.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long seq;
    private String userid;
    private String password;
    private String name;
    private Date reg_date;
    private int grade;
}
