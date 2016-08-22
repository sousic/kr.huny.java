package kr.huny.service;

import kr.huny.domain.MembersVO;
import kr.huny.dto.LoginDTO;

/**
 * Created by dhjang on 2016-08-22.
 */
public interface SignService {
    public MembersVO login(LoginDTO loginDTO) throws Exception;
}
