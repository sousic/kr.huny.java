package kr.huny.controller.admin;

import kr.huny.Exceptions.LogException;
import kr.huny.controller.common.baseController;
import kr.huny.domain.PageInfo;
import kr.huny.domain.board.ArticlesVO;
import kr.huny.persistence.board.ArticlesDAO;
import kr.huny.persistence.board.BoardManagerDAO;
import kr.huny.utils.PagingHelper;
import kr.huny.utils.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by sousic on 2016-10-04.
 */
@Controller
@RequestMapping(value = "${adminPath}/board/articles")
public class ArticlesController extends baseController {

    @Autowired
    private BoardManagerDAO boardManagerDAO;
    @Autowired
    private ArticlesDAO articlesDAO;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam("bm_seq") long bm_seq, Model model, PageInfo pageInfo)
    {
        String boardTitle = null;
        PagingHelper pagingHelper = new PagingHelper(RequestHelper.getCurrentRequest(), "bm_seq");
        pagingHelper.setPageInfo(pageInfo);

        model.addAttribute("bm_seq", bm_seq);

        try {
            //게시물 타이틀 추출
            boardTitle = boardManagerDAO.GetBoardIdToTitle(bm_seq);
            pagingHelper.setTotalCount(articlesDAO.articlesListCount(pageInfo));
            //목록조회
            model.addAttribute("list", articlesDAO.articlesList(pageInfo));

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

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@RequestParam("bm_seq") long bm_seq, Model model)
    {
        String boardTitle = null;
        model.addAttribute("bm_seq", bm_seq);

        try {
            //게시물 타이틀 추출
            boardTitle = boardManagerDAO.GetBoardIdToTitle(bm_seq);

            model.addAttribute("boardTitle", boardTitle);
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();
            return "admin/board/manager/list?bm_seq="+bm_seq;
        }

        return "admin/board/articles/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createOK(ArticlesVO articlesVO, Model model, RedirectAttributes rttr)
    {
        model.addAttribute("bm_seq", articlesVO.getBm_seq());

        try {
            articlesVO.setBm_seq(articlesVO.getBm_seq());
            articlesDAO.articleCreate(articlesVO);
            return "redirect:/" + adminPath +"/board/articles/list?bm_seq="+articlesVO.getBm_seq();
        }
        catch (Exception ex) {
            new LogException(ex).printStackTrace();

            rttr.addFlashAttribute("flag", "error");
            rttr.addFlashAttribute(articlesVO);

            return "redirect:/" + adminPath + "/board/articles/create";
        }
    }
}
