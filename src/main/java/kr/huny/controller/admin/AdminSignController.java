package kr.huny.controller.admin;

import kr.huny.controller.Sign.SignInHelper;
import kr.huny.controller.common.baseController;
import kr.huny.domain.member.MembersEnum;
import kr.huny.domain.member.MembersVO;
import kr.huny.dto.LoginDTO;
import kr.huny.service.SignService;
import kr.huny.utils.CookieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sousic on 2016-09-09.
 */
@Controller
@RequestMapping(value = "${adminPath}")
public class AdminSignController extends baseController {

    @Autowired
    private SignService signService;
    @Inject
    private SignInHelper signInHelper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model)
    {
        model.addAttribute("adminPath", adminPath);
        return "admin/login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginOK(LoginDTO loginDTO, Model model, HttpServletResponse response) throws Exception {
        MembersVO membersVO = signService.login(loginDTO);
        MembersEnum membersEnum= signInHelper.memberCheck(membersVO, loginDTO);

        if(membersEnum.getValue() == MembersEnum.LoginOK.getValue())
        {
            if(membersVO.getGrade() == 1)
            {
                CookieHelper.SetLoginSessionAdmin(membersVO, response, propertyHelper);
                return "redirect:/" + adminPath + "/home";
            }
        }
        model.addAttribute("adminPath", adminPath);

        return "admin/login/login";
    }
}
