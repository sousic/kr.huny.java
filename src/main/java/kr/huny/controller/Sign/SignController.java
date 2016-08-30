package kr.huny.controller.Sign;

import kr.huny.domain.MembersEnum;
import kr.huny.domain.MembersVO;
import kr.huny.dto.LoginDTO;
import kr.huny.service.SignService;
import kr.huny.utils.PropertyHelper;
import kr.huny.utils.SHA256Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sousic on 2016. 8. 17..
 */
@Controller
@RequestMapping(value="/sign")
public class SignController {
    private static final Logger logger = LoggerFactory.getLogger(SignController.class);

    @Inject
    private SignService signService;
    @Inject
    private SignInHelper signInHelper;
    @Autowired
    private PropertyHelper propertyHelper;


    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String login(Model model)
    {
        model.addAttribute("pageTitle","Signin");
        return "sign/signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String loginOK(LoginDTO loginDTO, HttpServletResponse response) throws Exception
    {
        loginDTO.setPwdfailcntLimit(propertyHelper.getLoginFailLimitCount());
        logger.info(loginDTO.toString());
        MembersVO membersVO = signService.login(loginDTO);

        MembersEnum membersEnum= signInHelper.memberCheck(membersVO, loginDTO);

        return "redirect:/";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(Model model) throws Exception
    {
        return "sign/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerOK(MembersVO membersVO, RedirectAttributes rtts) throws Exception
    {
        membersVO.setUserpwd(SHA256Helper.encrpyt(membersVO.getUserpwd()));
        logger.info(membersVO.toString());

        int result = signService.register(membersVO);
        if(result != 1)
        {
            rtts.addAttribute(membersVO);
            rtts.addAttribute("msg",result);
            return "sign/register";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/checker", method = RequestMethod.GET, produces = "application/json;charset=utf8")
    public ResponseEntity<Map<String, Object>> idChecker(String userid)
    {
        logger.info(userid);
        ResponseEntity<Map<String, Object>> entity = null;
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            MembersVO membersVO = signService.idChecker(userid);
            if(membersVO == null) {
                map.put("resultCode", 1);
                map.put("resultMsg", "성공");
            }
            else
            {
                map.put("resultCode", -1);
                map.put("resultMsg","사용중");
            }
            entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            map.put("resultCode", 0
            );
            map.put("resultMsg","실패");
            entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
