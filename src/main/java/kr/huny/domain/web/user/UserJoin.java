package kr.huny.domain.web.user;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserJoin extends UserLogin {

    @NotNull
    @Size(min=6, max=20)
    private String password_confirm;

    @NotNull
    @Size(min = 2, max=20)
    private String name;
}
