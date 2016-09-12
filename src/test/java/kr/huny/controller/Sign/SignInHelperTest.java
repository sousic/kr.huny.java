package kr.huny.controller.Sign;

import kr.huny.domain.member.MembersEnum;
import kr.huny.domain.member.MembersVO;
import kr.huny.dto.LoginDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;

/**
 * Created by dhjang on 2016-08-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class SignInHelperTest {
    MembersVO membersVO = new MembersVO();
    LoginDTO loginDTO = new LoginDTO();

    @Inject
    private SignInHelper signInHelper;

    private void InitMembersVO()
    {
        membersVO.setUserid("admin");
        membersVO.setUserpwd("admin");
        membersVO.setIsloginblock((short)0);
        membersVO.setPwdfailcnt((short)2);
    }

    private void InitLoginDTO()
    {
        loginDTO.setUserid("admin");
        loginDTO.setUserpwd("admin");
    }

    @Before
    public void setUp() throws Exception {
        InitMembersVO();
        InitLoginDTO();
    }

    @Test
    public void test_memberCheck_NotUserID() throws Exception {

        MembersEnum membersEnum = signInHelper.memberCheck(null, loginDTO);
        Assert.assertThat(MembersEnum.NotUserID, is(membersEnum));
    }

    @Test
    public void test_memberCheck_NotUserPWD() throws Exception {

        InitMembersVO();
        InitLoginDTO();

        loginDTO.setUserpwd("admin1");
        MembersEnum membersEnum = signInHelper.memberCheck(membersVO, loginDTO);
        Assert.assertThat(MembersEnum.NotUserPWD, is(membersEnum));
    }

    @Test
    public void test_memberCheck_PwdFailCount() throws Exception {
        membersVO.setPwdfailcnt((short)3);

        loginDTO.setUserpwd("admin");

        MembersEnum membersEnum = signInHelper.memberCheck(membersVO, loginDTO);

        Assert.assertThat(MembersEnum.PwdFailCount, is(membersEnum));
    }

    @Test
    public void test_memberCheck_LoginBlock() throws Exception {

        loginDTO.setUserpwd("admin");
        membersVO.setPwdfailcnt((short)0);
        membersVO.setIsloginblock((short)1);
        MembersEnum membersEnum = signInHelper.memberCheck(membersVO, loginDTO);

        Assert.assertThat(MembersEnum.LoginBlock, is(membersEnum));
    }
}