package kr.huny.domain.web.user;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserJoin {
    @NotNull
    @Size(min = 4, max=20)
    private String userid;

    @NotNull
    @Size(min=6, max=20)
    private String password;

    @NotNull
    @Size(min=6, max=20)
    private String password_confirm;

    @NotNull
    @Size(min = 2, max=20)
    private String name;
}
