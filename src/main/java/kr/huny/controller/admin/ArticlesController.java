package kr.huny.controller.admin;

import kr.huny.Exceptions.LogException;
import kr.huny.controller.common.baseController;
import kr.huny.domain.PageInfo;
import kr.huny.persistence.board.BoardManagerDAO;
import kr.huny.utils.PagingHelper;
import kr.huny.utils.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sousic on 2016-10-04.
 */
@Controller
@RequestMapping(value = "${adminPath}/board/article/{bm_seq}")
public class ArticlesController extends baseController {

    @Autowired
    private BoardManagerDAO boardManagerDAO;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@PathVariable("bm_seq") long bm_seq, Model model, PageInfo pageInfo)
    {
        String boardTitle = null;
        PagingHelper pagingHelper = new PagingHelper(RequestHelper.getCurrentRequest());
        pagingHelper.setPageInfo(pageInfo);

        try {
            //게시물 타이틀 추출
            boardTitle = boardManagerDAO.GetBoardIdToTitle(bm_seq);

            //목록조회

            model.addAttribute("boardTitle", boardTitle);
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();
            return "admin/board/manager/list";
        }

        model.addAttribute("pagingHelper", pagingHelper);

        return "admin/board/articles/list";
    }
}
