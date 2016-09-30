package kr.huny.controller.Sign;

import kr.huny.Exceptions.LogException;
import kr.huny.controller.common.baseController;
import kr.huny.domain.member.LoginHistoryVO;
import kr.huny.domain.member.MembersEnum;
import kr.huny.domain.member.MembersVO;
import kr.huny.dto.LoginDTO;
import kr.huny.service.LoginHistoryService;
import kr.huny.service.SignService;
import kr.huny.utils.CookieHelper;
import kr.huny.utils.RequestHelper;
import kr.huny.utils.SHA256Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sousic on 2016. 8. 17..
 */
@Controller
@RequestMapping(value="/sign")
public class SignController extends baseController {

    @Autowired
    private SignService signService;
    @Autowired
    private LoginHistoryService loginHistoryService;
    @Inject
    private SignInHelper signInHelper;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String login(Model model)
    {
        model.addAttribute("pageTitle","Signin");
        return "sign/signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String loginOK(LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rtts)
    {
        loginDTO.setPwdfailcntLimit(propertyHelper.getLoginFailLimitCount());
        MembersVO membersVO = null;
        try {
            membersVO = signService.login(loginDTO);
        } catch (Exception e) {
            new LogException(e).printStackTrace();
        }
        MembersEnum membersEnum= signInHelper.memberCheck(membersVO, loginDTO);

        if(membersEnum.getValue() == MembersEnum.NotUserPWD.getValue() || membersEnum.getValue() == membersEnum.PwdFailCount.getValue()) {
            signService.UpdatePwdFailCount(membersVO);
        }

        if(membersVO == null) {
            rtts.addFlashAttribute("flag", MembersEnum.NotUserID);
        } else {

            if (membersVO.getPwdfailcnt() >= propertyHelper.getLoginFailLimitCount()) {
                signService.SetIsLoginBlock(membersVO.getSeq(), 1);
            }
            LoginHistoryVO loginHistoryVO = new LoginHistoryVO();
            loginHistoryVO.setUserid(loginDTO.getUserid());
            loginHistoryVO.setRemoteip(RequestHelper.remoteIP(request));
            loginHistoryVO.setFlag((short) 1);
            loginHistoryVO.setResult(membersEnum.toString());
            try {
                loginHistoryService.InsertLoginHistory(loginHistoryVO);
            } catch (Exception e) {
                new LogException(e).printStackTrace();
            }

            if (membersEnum.getValue() == MembersEnum.LoginOK.getValue()) {
                membersVO.setPwdfailcnt((short) 0);
                signService.UpdatePwdFailCount(membersVO);
                signService.SetIsLoginBlock(membersVO.getSeq(), 0);

                CookieHelper.SetLoginSession(membersVO, response, propertyHelper);
                return "redirect:/";
            }
        }

        rtts.addFlashAttribute("flag", membersEnum);
        rtts.addFlashAttribute("userid",loginDTO.getUserid());
        return "redirect:/sign/signin";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(Model model)
    {
        return "sign/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerOK(MembersVO membersVO, RedirectAttributes rtts)
    {
        membersVO.setUserpwd(SHA256Helper.encrpyt(membersVO.getUserpwd()));
        logger.info(membersVO.toString());

        int result = 0;
        try {
            result = signService.register(membersVO);
        } catch (Exception e) {
            new LogException(e).printStackTrace();
        }
        if(result != 1)
        {
            rtts.addFlashAttribute(membersVO);
            rtts.addFlashAttribute("msg",result);
            return "redirect:/sign/register";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/checker", method = RequestMethod.GET, produces = "application/json;charset=utf8")
    public ResponseEntity<Map<String, Object>> idChecker(String userid)
    {
        logger.info(userid);
        ResponseEntity<Map<String, Object>> entity = null;

        resultJson = new HashMap<String, Object>();

        try {
            MembersVO membersVO = signService.idChecker(userid);
            if(membersVO == null) {
                resultJson.put("resultCode", 1);
                resultJson.put("resultMsg", "성공");
            }
            else
            {
                resultJson.put("resultCode", -1);
                resultJson.put("resultMsg","사용중");
            }
            entity = new ResponseEntity<Map<String, Object>>(resultJson, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();
            resultJson.put("resultCode", 0
            );
            resultJson.put("resultMsg","실패");
            entity = new ResponseEntity<Map<String, Object>>(resultJson, HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
