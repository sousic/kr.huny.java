package kr.huny.dto;

import lombok.Data;

/**
 * Created by sousic on 2016-09-13.
 * 관리자용, 기본세션 정보 상속
 */
@Data
public class SessionAdminDTO extends SessionDTO {
    public SessionAdminDTO()
    {
        IsAdmin = true;
    }

    private boolean IsAdmin;
}
