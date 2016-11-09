package kr.huny.controller;

import kr.huny.controller.common.baseController;
import kr.huny.domain.web.user.UserLogin;
import kr.huny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by sousic on 2016-11-04.
 */
@Controller
@RequestMapping("/")
public class SignController extends baseController {

    @Autowired
    UserService userService;

    @Resource
    LocaleResolver localeResolver;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login()
    {
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginSuccess(@Valid UserLogin userLogin, BindingResult result, HttpServletResponse response, HttpServletRequest request)
    {
        Locale locale = localeResolver.resolveLocale(request);

        if(result.hasErrors())
        {
            logger.debug("result="+ result);
            return "user/login";
        }

        if(!userService.UserLogin(userLogin, response, request, propertyHelper, locale))
        {
            result.rejectValue("password", "user.msg.login.failure");
            logger.debug("result="+ result);
            return "user/login";
        }

        return "redirect:/home";
    }
}
