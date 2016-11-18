package kr.huny.persistence;

import kr.huny.domain.PageInfo;
import kr.huny.domain.db.Category;

import java.util.List;

/**
 * Created by sousic on 2016-11-18.
 */
public interface CategoryDAO {

    List<Category> CategoryList(int level, PageInfo pageInfo);
}
