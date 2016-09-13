package kr.huny.persistence.member;

import kr.huny.domain.member.MembersVO;
import kr.huny.dto.LoginDTO;

import java.util.Map;

/**
 * Created by dhjang on 2016-08-22.
 */
public interface MembersDAO {
    public MembersVO login(LoginDTO loginDTO) throws Exception;

    public MembersVO idChecker(String userid) throws Exception;

    public void register(MembersVO membersVO) throws Exception;

    public void UpdatePwdFailCount(MembersVO membersVO);

    public void SetIsLoginBlock(Map<String, Object> params);
}
