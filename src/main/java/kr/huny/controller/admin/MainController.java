package kr.huny.controller.admin;

import kr.huny.controller.common.baseController;
import kr.huny.utils.CookieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sousic on 2016-09-13.
 */
@Controller
@RequestMapping(value = "${adminPath}")
public class MainController extends baseController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Index(Model model)
    {
        model.addAttribute("nickname", CookieHelper.NickName(propertyHelper));

        return "admin/home/Index";
    }
}
