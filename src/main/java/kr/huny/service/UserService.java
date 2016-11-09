package kr.huny.service;

import kr.huny.domain.db.User;
import kr.huny.domain.web.user.UserLogin;
import kr.huny.utils.PropertyHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by sousic on 2016-11-08.
 */
public interface UserService {
    void userJoin(User user);

    Boolean UserLogin(UserLogin userLogin, HttpServletResponse response, HttpServletRequest request, PropertyHelper propertyHelpe, Locale locale);
}
