package kr.huny.persistence.board;

import kr.huny.domain.board.BoardManageVO;
import kr.huny.domain.PageInfo;

import java.util.List;

/**
 * Created by sousic on 2016. 9. 8..
 */
public interface BoardManagerDAO {
    public List<BoardManageVO> boardManagerListPage(PageInfo pageInfo);
}
