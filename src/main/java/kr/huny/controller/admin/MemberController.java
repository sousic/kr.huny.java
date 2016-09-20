package kr.huny.controller.admin;

import kr.huny.controller.common.baseController;
import kr.huny.domain.PageInfo;
import kr.huny.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    LoginHistoryService loginHistoryService;

    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String LoginHistory(Model model, PageInfo pageInfo)
    {
        model.addAttribute("list",loginHistoryService.GetLoginHistoryList(pageInfo));

        return "admin/member/history";
    }
}
