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
        MembersVO idCheckerVO = idChecker(membersVO.getUserid());

        if(idCheckerVO != null && idCheckerVO.getUserid().equals(membersVO.getUserid()))
        {
            return -1;
        }

        try {
            membersDAO.register(membersVO);
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
