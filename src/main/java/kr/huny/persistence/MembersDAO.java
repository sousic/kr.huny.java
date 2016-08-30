package kr.huny.persistence;

import kr.huny.domain.MembersVO;
import kr.huny.dto.LoginDTO;

/**
 * Created by dhjang on 2016-08-22.
 */
public interface MembersDAO {
    public MembersVO login(LoginDTO loginDTO) throws Exception;

    public MembersVO idChecker(String userid) throws Exception;
}
