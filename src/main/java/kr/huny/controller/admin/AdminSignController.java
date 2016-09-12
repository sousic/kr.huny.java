package kr.huny.controller.admin;

import kr.huny.controller.common.baseController;
import kr.huny.dto.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-09-09.
 */
@Controller
@RequestMapping(value = "${adminPath}")
public class AdminSignController extends baseController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model)
    {
        model.addAttribute("adminPath", adminPath);
        return "admin/sign/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginOK(LoginDTO loginDTO, Model model)
    {
        return "admin/sign/login";
    }
}
