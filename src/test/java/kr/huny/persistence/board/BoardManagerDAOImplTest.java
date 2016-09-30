package kr.huny.persistence.board;

import kr.huny.domain.PageInfo;
import kr.huny.domain.board.BoardManagerVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.core.Is.is;

/**
 * Created by sousic on 2016-09-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/beans-context.xml"
})
@WebAppConfiguration
public class BoardManagerDAOImplTest {
    @Autowired
    private BoardManagerDAO boardManagerDAO;
    private PageInfo pageInfo;

    @Before
    public void setUp() throws Exception {
        pageInfo = new PageInfo();
    }

    @Test
    public void boardManagerList() throws Exception {
        List<BoardManagerVO> list = boardManagerDAO.boardManagerList(pageInfo);

        Assert.assertThat(1, is(list.size()));
    }

    @Test
    public void boardManagerListCount() throws Exception {
        int count = boardManagerDAO.boardManagerListCount(pageInfo);

        Assert.assertThat(1, is(count));
    }

    //@Test
    public void insertBoardManager() throws Exception {

    }

    @Test
    public void readBoardManager() throws Exception {
        BoardManagerVO boardManagerVO = boardManagerDAO.readBoardManager(1);

        System.out.println(boardManagerVO.toString());

        Assert.assertThat(1, is(boardManagerVO.getSeq()));
    }

    @Test
    public void updateBoardManager() throws Exception {
        String updateDescription = "자유게시판 수정";

        //read
        BoardManagerVO boardManagerVO = boardManagerDAO.readBoardManager(1);
        boardManagerVO.setDescription(updateDescription);

        //update
        boardManagerDAO.updateBoardManager(boardManagerVO);
        boardManagerVO = boardManagerDAO.readBoardManager(1);

        Assert.assertThat(updateDescription, is(boardManagerVO.getDescription()));
        System.out.println(boardManagerVO.toString());

        boardManagerVO.setDescription("자유게시판");
        boardManagerDAO.updateBoardManager(boardManagerVO);
    }

}