package kr.huny.controller.admin;

import kr.huny.controller.common.baseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-09-09.
 */
@Controller
@RequestMapping(value = "${adminPath}")
public class AdminSignController extends baseController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login()
    {
        return "admin/sign/Login";
    }
}
