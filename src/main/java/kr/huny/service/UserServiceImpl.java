package kr.huny.service;

import kr.huny.domain.db.User;
import kr.huny.domain.web.user.UserLogin;
import kr.huny.persistence.UserDAO;
import kr.huny.utils.CookieHelper;
import kr.huny.utils.PropertyHelper;
import kr.huny.utils.SHA256Helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by sousic on 2016-11-08.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    CommonService commonService;

    @Override
    public void userJoin(User user) {

        userDAO.joinUser(user);

        log.debug(user.toString());
    }

    @Override
    public Boolean UserLogin(UserLogin userLogin, HttpServletResponse response, HttpServletRequest request, PropertyHelper propertyHelper, Locale locale)
    {
        Boolean results = true;

        User user = userDAO.findById(userLogin.getUserid());

        if(user == null) {
            //throw new NotFoundAccountException(commonService.getResourceBundleMessage(locale, "messages.user","user.msg.login.failure"));
            results = false;
        } else {
            if (!user.getPassword().equals(SHA256Helper.encrpyt(userLogin.getPassword()))) {
                results = false;
            }
        }
        if(results) {
            CookieHelper.SetLoginSession(user, response, propertyHelper);
        }

        return results;
    }
}
