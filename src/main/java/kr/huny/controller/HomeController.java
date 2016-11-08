package kr.huny.controller;

import kr.huny.controller.common.baseController;
import kr.huny.dto.SessionDTO;
import kr.huny.utils.CookieHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends baseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home()
	{
		return "redirect:/home";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		SessionDTO sessionDTO = CookieHelper.LoginSession(request, propertyHelper);
		logger.info((sessionDTO == null) ? "" : sessionDTO.toString());

		return "home";
	}
	
}
