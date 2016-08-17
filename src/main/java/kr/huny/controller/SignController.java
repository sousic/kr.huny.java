package kr.huny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016. 8. 17..
 */
@Controller
@RequestMapping(value="/sign")
public class SignController {
    private static final Logger logger = LoggerFactory.getLogger(SignController.class);

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String login(Model model)
    {
        model.addAttribute("pageTitle","Signin");
        return "sign/signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String loginOK()
    {
        return "redirect:/home";
    }
}
