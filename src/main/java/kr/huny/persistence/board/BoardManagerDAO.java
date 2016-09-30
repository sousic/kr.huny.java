package kr.huny.persistence.board;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.BoardManagerVO;

import java.util.List;

/**
 * Created by sousic on 2016. 9. 8..
 */
public interface BoardManagerDAO {
    public List<BoardManagerVO> boardManagerList(PageInfo pageInfo);
    public int boardManagerListCount(PageInfo pageInfo);

    public void insertBoardManager(BoardManagerVO boardManagerVO);
    public BoardManagerVO readBoardManager(int seq);
    public void updateBoardManager(BoardManagerVO boardManagerVO);
}
