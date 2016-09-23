package kr.huny.service;

import kr.huny.domain.PageInfo;
import kr.huny.domain.member.LoginHistoryVO;

import java.util.List;

/**
 * Created by sousic on 2016-09-12.
 */
public interface LoginHistoryService {
    public void InsertLoginHistory(LoginHistoryVO loginHistoryVO) throws Exception;

    public List<LoginHistoryVO> GetLoginHistoryList(PageInfo pageInfo);

    public int GetLoginHistoryListCount(PageInfo pageInfo);
}
