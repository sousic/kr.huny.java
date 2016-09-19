package kr.huny.controller.admin;

import kr.huny.controller.common.baseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-09-19.
 */
@Controller
@RequestMapping(value = "${adminPath}/member")
public class MemberController  extends baseController {

    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String LoginHistory(Model model)
    {
        return "admin/member/history";
    }
}
