package kr.huny.service;

import kr.huny.domain.member.LoginHistoryVO;

/**
 * Created by sousic on 2016-09-12.
 */
public interface LoginHistoryService {
    public void InsertLoginHistory(LoginHistoryVO loginHistoryVO) throws Exception;
}
