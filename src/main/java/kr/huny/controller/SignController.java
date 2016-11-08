package kr.huny.controller;

import kr.huny.controller.common.baseController;
import kr.huny.domain.web.user.UserJoin;
import kr.huny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by sousic on 2016-11-04.
 */
@Controller
@RequestMapping("/")
public class SignController extends baseController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "join", method = RequestMethod.GET)
    public String join(Model model)
    {
        model.addAttribute("userJoin", new UserJoin());
        return "user/join";
    }

    @RequestMapping(value = "join", method = RequestMethod.POST)
    public String joinOK(@Valid UserJoin userJoin, BindingResult result)
    {
        if(result.hasErrors())
        {
            logger.debug("result="+ result);
            return "user/join";
        }

        String pwd = userJoin.getPassword().trim();
        String pwdCfm = userJoin.getPassword_confirm().trim();

        if(!pwd.equals(pwdCfm))
        {
            result.rejectValue("password_confirm","user.msg.password.mismatch");
            return "user/join";
        }



        //userService.userJoin(user);

        return "redirect:/";
    }
}
