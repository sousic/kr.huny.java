package kr.huny.service;

import kr.huny.domain.db.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by sousic on 2016-11-08.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void userJoin(User user) {



        log.debug(user.toString());
    }
}
