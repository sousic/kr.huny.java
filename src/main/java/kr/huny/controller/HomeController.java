package kr.huny.controller;

import kr.huny.controller.common.baseController;
import kr.huny.dto.SessionDTO;
import kr.huny.utils.SessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends baseController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SessionHelper sessionHelper;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Cookie encSessionDTOCookie = WebUtils.getCookie(request, propertyHelper.getCookieName());
		logger.info(encSessionDTOCookie.getValue());
		SessionDTO sessionDTO = null;
		try {
			sessionDTO = sessionHelper.LoginSession(encSessionDTOCookie.getValue());
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			logger.info(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			locale.equals(e.toString());
		}
		logger.info(sessionDTO.toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("pageTitle","Home");

		return "home";
	}
	
}
