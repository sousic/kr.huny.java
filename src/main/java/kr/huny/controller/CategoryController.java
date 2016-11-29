package kr.huny.controller;

import kr.huny.controller.common.baseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-11-18.
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController extends baseController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list()
    {
        return "category/list";
    }
}
