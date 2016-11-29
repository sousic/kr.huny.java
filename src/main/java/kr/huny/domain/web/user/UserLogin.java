package kr.huny.domain.web.user;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * Created by sousic on 2016-11-09.
 */
@Data
public class UserLogin {
    @NotNull
    @Size(min = 4, max=20)
    private String userid;

    @NotNull
    @Size(min=6, max=20)
    private String password;

    private int grade;
}
