package kr.huny.interceptor;

import kr.huny.dto.SessionDTO;
import kr.huny.utils.CookieHelper;
import kr.huny.utils.PropertyHelper;
import kr.huny.utils.session.LoginSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sousic on 2016-09-13.
 */
public class AuthAdminInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AuthAdminInterceptor.class);

    @Inject
    private PropertyHelper propertyHelper;
    @Inject
    private LoginSession loginSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /*
        SessionAdminDTO sessionAdminDTO = CookieHelper.LoginSessionAdmin(request, propertyHelper);
        //logger.info(sessionAdminDTO.toString());
        if(sessionAdminDTO == null)
        {
            response.sendRedirect("/");
            return false;
        }
        */
        SessionDTO sessionDTO = CookieHelper.LoginSession(request, propertyHelper);
        logger.info(sessionDTO == null ? "NOT ADMIN" : sessionDTO.toString());
        if(sessionDTO == null)
        {
            response.sendRedirect("/");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //super.postHandle(request, response, handler, modelAndView);

        //if(modelAndView != null) {
        //    ModelMap modelMap = modelAndView.getModelMap();

            //관리자 페이지의 모델 정보가 있을시 관리자 페이지 경로가 커스텀이라서 모델에 추가해 준다
            //닉네임도 같이 넣어줌
            //if (modelMap != null) {
                //modelMap.addAttribute("nickname", CookieHelper.NickName(propertyHelper));
                //modelMap.addAttribute("adminPath", String.format("/%s", propertyHelper.getAdminPath()));
            //}

            request.setAttribute("isLogin", loginSession.IsLoginSession());
            request.setAttribute("nickname", loginSession.NickName());
        //}
    }
}
