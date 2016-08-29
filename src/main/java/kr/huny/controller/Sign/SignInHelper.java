package kr.huny.controller.Sign;

import kr.huny.domain.MembersEnum;
import kr.huny.domain.MembersVO;
import kr.huny.dto.LoginDTO;
import kr.huny.utils.SHA256Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by dhjang on 2016-08-22.
 */
@Service
public class SignInHelper {

    private static final Logger logger = LoggerFactory.getLogger(SignInHelper.class);

    @Resource(name="loginFialLimitCount")
    private int loginFialLimitCount;

    public MembersEnum memberCheck(MembersVO membersVO, LoginDTO loginDTO)
    {
        MembersEnum membersEnum = null;

        if(membersVO == null) {
            membersEnum = MembersEnum.NotUserID;
        }
        else if(membersVO.getUserid().equals(loginDTO.getUserid()))
        {
            logger.info(membersVO.toString());
            //1순위는 로그인 블럭 확인
            if (membersVO.getIsloginblock() == 1) {
                membersEnum = MembersEnum.LoginBlock;
            }
            else
            {
                //2순위는 로그인 횟수 확인
                if (membersVO.getPwdfailcnt() >= loginFialLimitCount) {
                    membersEnum = MembersEnum.PwdFailCount;
                }
                else
                {
                    //3순위는 암호 확인
                    if (!CheckPassword(membersVO.getUserpwd(), loginDTO.getUserpwd())) {
                        membersEnum = MembersEnum.NotUserPWD;
                    }
                }
            }
        }

        return membersEnum;
    }

    private boolean CheckPassword(String encPwd, String loginPwd)
    {
        String encLoginPwd = SHA256Helper.encrpyt(loginPwd);

        return encPwd.equals(encLoginPwd);
    }
}
