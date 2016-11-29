package kr.huny.controller.user;

import kr.huny.controller.common.baseController;
import kr.huny.domain.db.User;
import kr.huny.domain.web.user.UserJoin;
import kr.huny.service.UserService;
import kr.huny.utils.CookieHelper;
import kr.huny.utils.SHA256Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController extends baseController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "join", method = RequestMethod.GET)
    public String join(Model model)
    {
        model.addAttribute("userJoin", new UserJoin());
        return "user/join";
    }

    @RequestMapping(value = "join", method = RequestMethod.POST)
    public String joinOK(@Valid UserJoin userJoin, BindingResult result, HttpServletRequest request, HttpServletResponse response)
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

        User user = User.builder()
                .userid(userJoin.getUserid())
                .password(SHA256Helper.encrpyt(userJoin.getPassword()))
                .name(userJoin.getName())
                .build();

        userService.userJoin(user);

        CookieHelper.SetLoginSession(user, response, propertyHelper);

        return "redirect:/login";
    }
}
