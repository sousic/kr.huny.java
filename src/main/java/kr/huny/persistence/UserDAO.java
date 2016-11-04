package kr.huny.persistence;

import kr.huny.domain.db.User;

/**
 * Created by sousic on 2016-11-04.
 */
public interface UserDAO {
    User findById(String userid);
}
