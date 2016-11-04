package kr.huny.controller;

import kr.huny.controller.common.baseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-11-04.
 */
@Controller
@RequestMapping("/")
public class SignController extends baseController {

    @RequestMapping(value = "join", method = RequestMethod.GET)
    public String join()
    {
        return "user/join";
    }
}
