package kr.huny.persistence;

import kr.huny.domain.PageInfo;
import kr.huny.domain.db.Category;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sousic on 2016-11-18.
 */
@Slf4j
@Repository
public class CategoryDAOImpl implements CategoryDAO {
    private final String namespace = "kr.huny.persistence.CategoryDAO";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Category> CategoryList(int level, PageInfo pageInfo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("level", level);
        paramMap.put("pageInfo", pageInfo);

        return sqlSession.selectList(namespace + ".CategoryList", paramMap);
    }
}
