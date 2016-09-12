package kr.huny.service;

import kr.huny.domain.member.LoginHistoryVO;
import kr.huny.persistence.member.LoginHistoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sousic on 2016-09-12.
 */
@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

    @Autowired
    LoginHistoryDAO loginHistoryDAO;

    @Override
    public void InsertLoginHistory(LoginHistoryVO loginHistoryVO) throws Exception {
        loginHistoryDAO.InsertLoginHisotry(loginHistoryVO);
    }
}
