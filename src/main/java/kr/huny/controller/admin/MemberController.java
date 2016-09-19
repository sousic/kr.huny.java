package kr.huny.controller.admin;

import kr.huny.Exceptions.LogException;
import kr.huny.controller.common.baseController;
import kr.huny.domain.PageInfo;
import kr.huny.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sousic on 2016-09-19.
 */
@Controller
@RequestMapping(value = "${adminPath}/member")
public class MemberController  extends baseController {

    @Autowired
    LoginHistoryService loginHistoryService;

    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String LoginHistory(Model model)
    {
        return "admin/member/history";
    }

    @RequestMapping(value = "historylist", method = RequestMethod.GET, produces = "application/json;charset=utf8")
    public ResponseEntity<Map<String,Object>> HistoryList(PageInfo pageInfo)
    {
        ResponseEntity<Map<String,Object>> entity = null;
        resultJson = new HashMap<String, Object>();

        try {
            resultJson.put("resultCode", 1);
            resultJson.put("resultMsg", "성공");
            resultJson.put("data", loginHistoryService.GetLoginHistoryList(pageInfo));

            entity = new ResponseEntity<Map<String, Object>>(resultJson, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();
            resultJson.put("resultCode", 0);
            resultJson.put("resultMsg", "Error");
            resultJson.put("errorMsg", ex.toString());

            entity = new ResponseEntity<Map<String, Object>>(resultJson, HttpStatus.OK);
        }
        return entity;
    }
}
