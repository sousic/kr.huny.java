package kr.huny.persistence.member;

import kr.huny.domain.member.LoginHistoryVO;

/**
 * Created by sousic on 2016-09-12.
 */
public interface LoginHistoryDAO {
    public void InsertLoginHisotry(LoginHistoryVO loginHistoryVO) throws Exception;
}
