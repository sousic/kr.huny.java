package kr.huny.controller;

import kr.huny.controller.common.baseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-11-08.
 */
@Controller
@RequestMapping(value = "/board")
public class boardController extends baseController {

    @RequestMapping(value = "/free", method = RequestMethod.GET)
    public String freeBoard()
    {
        return "board/freeBoard";
    }
}
