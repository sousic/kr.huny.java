package kr.huny.service;

import kr.huny.domain.db.User;
import kr.huny.persistence.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sousic on 2016-11-08.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void userJoin(User user) {

        userDAO.joinUser(user);

        log.debug(user.toString());
    }
}
