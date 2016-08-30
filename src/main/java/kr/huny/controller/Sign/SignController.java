package kr.huny.controller.Sign;

import kr.huny.domain.MembersEnum;
import kr.huny.domain.MembersVO;
import kr.huny.dto.LoginDTO;
import kr.huny.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sousic on 2016. 8. 17..
 */
@Controller
@RequestMapping(value="/sign")
public class SignController {
    private static final Logger logger = LoggerFactory.getLogger(SignController.class);

    @Inject
    private SignService signService;
    @Inject
    private SignInHelper signInHelper;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String login(Model model)
    {
        model.addAttribute("pageTitle","Signin");
        return "sign/signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String loginOK(LoginDTO loginDTO, HttpServletResponse response) throws Exception
    {
        logger.info(loginDTO.toString());

        MembersVO membersVO = signService.login(loginDTO);

        MembersEnum membersEnum= signInHelper.memberCheck(membersVO, loginDTO);

        return "redirect:/";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(Model model) throws Exception
    {
        return "sign/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerOK(MembersVO membersVO, RedirectAttributes rtts) throws Exception
    {
        return "redirect:/";
    }
}