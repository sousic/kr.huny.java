package kr.huny.service;

import kr.huny.domain.MembersVO;
import kr.huny.dto.LoginDTO;
import kr.huny.persistence.MemberGradeDAO;
import kr.huny.persistence.MembersDAO;
import kr.huny.utils.PropertyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by dhjang on 2016-08-22.
 */
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    MembersDAO membersDAO;
    @Autowired
    MemberGradeDAO memberGradeDAO;
    @Autowired
    PropertyHelper propertyHelper;

    @Override
    public MembersVO login(LoginDTO loginDTO) throws Exception {
        return membersDAO.login(loginDTO);
    }

    @Override
    public MembersVO idChecker(String userid) throws Exception {
        return membersDAO.idChecker(userid);
    }

    @Transactional
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
            //회원가입시 일반 회원등급인 10레벨로 고정함
            memberGradeDAO.UpdateMemberGradeCount(propertyHelper.getRegisterMemberGrade());
            result = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = 0;
        }

        return result;
    }
}
