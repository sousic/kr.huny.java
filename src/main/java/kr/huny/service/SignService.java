package kr.huny.service;

import kr.huny.domain.member.MembersVO;
import kr.huny.dto.LoginDTO;

import java.lang.reflect.Member;

/**
 * Created by dhjang on 2016-08-22.
 */
public interface SignService {
    public MembersVO login(LoginDTO loginDTO) throws Exception;

    public MembersVO idChecker(String userid) throws Exception;
    /**
     * 회원 등록
     * @param membersVO
     * @return 1 : 성공, 0 : 실패, -1 : 아이디 중복
     * @throws Exception
     */
    public int register(MembersVO membersVO) throws Exception;

    public void UpdatePwdFailCount(MembersVO membersVO);

    public void SetIsLoginBlock(long seq, int flag);
}
