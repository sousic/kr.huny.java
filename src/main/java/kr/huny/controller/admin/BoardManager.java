package kr.huny.controller.admin;

import kr.huny.controller.common.baseController;
import kr.huny.domain.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-09-27.
 */
@Controller
@RequestMapping(value = "${adminPath}/board/manager")
public class BoardManager extends baseController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model, PageInfo pageInfo)
    {
        return "admin/board/manager/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model)
    {
        return "admin/board/manager/create";
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String view(Model model)
    {
        return "admin/baord/manager/view";
    }

    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public String modify(Model model)
    {
        return "admin/board/manager/modify";
    }
}
