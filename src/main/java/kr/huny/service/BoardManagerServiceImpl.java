package kr.huny.service;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.BoardManagerVO;
import kr.huny.persistence.board.BoardManagerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sousic on 2016-10-12.
 */
@Service
public class BoardManagerServiceImpl implements BoardManagerService {

    @Autowired
    BoardManagerDAO boardManagerDAO;

    @Override
    public int boardManagerListCount(PageInfo pageInfo) throws Exception {
        return boardManagerDAO.boardManagerListCount(pageInfo);
    }

    @Override
    public List<BoardManagerVO> boardManagerList(PageInfo pageInfo) throws Exception {
        return boardManagerDAO.boardManagerList(pageInfo);
    }

    @Override
    public void insertBoardManager(BoardManagerVO boardManagerVO) throws Exception {
        boardManagerDAO.insertBoardManager(boardManagerVO);
    }

    @Override
    public BoardManagerVO readBoardManager(int seq) throws Exception {
        return boardManagerDAO.readBoardManager(seq);
    }

    @Override
    public void updateBoardManager(BoardManagerVO boardManagerVO) throws Exception {
        boardManagerDAO.updateBoardManager(boardManagerVO);
    }

    @Override
    public String GetBoardIdToTitle(long bm_seq) throws Exception {
        return boardManagerDAO.GetBoardIdToTitle(bm_seq);
    }
}
