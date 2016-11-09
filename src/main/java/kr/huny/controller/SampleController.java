package kr.huny.controller;

import kr.huny.controller.common.baseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-11-09.
 */
@Slf4j
@Controller
@RequestMapping(value = "/sample")
public class SampleController extends baseController {

    @RequestMapping(value = "/angular", method = RequestMethod.GET)
    public String angular_test()
    {
        return "s/angulartest";
    }
}
