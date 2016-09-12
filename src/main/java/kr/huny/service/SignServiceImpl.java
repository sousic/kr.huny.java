package kr.huny.service;

import kr.huny.domain.MembersVO;
import kr.huny.dto.LoginDTO;
import kr.huny.persistence.MembersDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by dhjang on 2016-08-22.
 */
@Service
public class SignServiceImpl implements SignService {

    @Inject
    MembersDAO membersDAO;

    @Override
    public MembersVO login(LoginDTO loginDTO) throws Exception {
        return membersDAO.login(loginDTO);
    }

    @Override
    public MembersVO idChecker(String userid) throws Exception {
        return membersDAO.idChecker(userid);
    }

    @Override
    public int register(MembersVO membersVO) throws Exception
    {
        int result = 0;
        MembersVO idCheckerVO = idChecker(membersVO.getUserid());

        if(idCheckerVO != null && idCheckerVO.getUserid().equals(membersVO.getUserid()))
        {
            result = -1;
        }

        try {
            membersDAO.register(membersVO);
            result = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = 0;
        }

        return result;
    }
}
