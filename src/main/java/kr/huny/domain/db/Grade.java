package kr.huny.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

/**
 * Created by sousic on 2016-11-29.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private int gradeCode;
    private int gradeName;
    private DateTime regdate;
    private String desc;
}
