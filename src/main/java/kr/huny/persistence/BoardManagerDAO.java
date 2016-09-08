package kr.huny.persistence;

import kr.huny.domain.BoardManageVO;
import kr.huny.domain.PageInfo;

import java.util.List;

/**
 * Created by sousic on 2016. 9. 8..
 */
public interface BoardManagerDAO {
    public List<BoardManageVO> boardManagerListPage(PageInfo pageInfo);
}
