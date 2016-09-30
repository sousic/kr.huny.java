package kr.huny.persistence.board;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.BoardManagerVO;

import java.util.List;

/**
 * Created by sousic on 2016. 9. 8..
 */
public interface BoardManagerDAO {
    public List<BoardManagerVO> boardManagerList(PageInfo pageInfo) throws Exception;
    public int boardManagerListCount(PageInfo pageInfo) throws Exception;

    public void insertBoardManager(BoardManagerVO boardManagerVO) throws Exception;
    public BoardManagerVO readBoardManager(int seq) throws Exception;
    public void updateBoardManager(BoardManagerVO boardManagerVO) throws Exception;
}
