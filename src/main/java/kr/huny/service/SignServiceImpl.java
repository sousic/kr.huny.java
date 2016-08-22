package kr.huny.service;

import kr.huny.domain.MembersVO;
import kr.huny.dto.LoginDTO;
import kr.huny.persistence.MembersDAO;
import org.apache.ibatis.session.SqlSession;
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
}
