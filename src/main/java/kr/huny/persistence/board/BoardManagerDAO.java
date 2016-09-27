package kr.huny.persistence.board;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.BoardManageVO;

import java.util.List;

/**
 * Created by sousic on 2016. 9. 8..
 */
public interface BoardManagerDAO {
    public List<BoardManageVO> boardManagerList(PageInfo pageInfo);
    public int boardManagerListCount(PageInfo pageInfo);
}
