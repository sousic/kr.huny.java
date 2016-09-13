package kr.huny.controller.admin;

import kr.huny.controller.common.baseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-09-13.
 */
@Controller
@RequestMapping(value = "${adminPath}")
public class MainController extends baseController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Index()
    {
        return "admin/home/Index";
    }
}
