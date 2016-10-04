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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by sousic on 2016-10-04.
 */
@Controller
@RequestMapping(value = "${adminPath}/board/articles/{bm_seq}")
public class ArticlesController extends baseController {

    @Autowired
    private BoardManagerDAO boardManagerDAO;
    @Autowired
    private ArticlesDAO articlesDAO;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@PathVariable("bm_seq") long bm_seq, Model model, PageInfo pageInfo)
    {
        String boardTitle = null;
        PagingHelper pagingHelper = new PagingHelper(RequestHelper.getCurrentRequest());
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
    public String create(@PathVariable("bm_seq") long bm_seq, Model model)
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
            return "admin/board/manager/list";
        }

        return "admin/board/articles/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createOK(@PathVariable("bm_seq") long bm_seq, ArticlesVO articlesVO, Model model, RedirectAttributes rttr)
    {
        model.addAttribute("bm_seq", bm_seq);

        RedirectView rv = null;

        try {
            articlesVO.setBm_seq(bm_seq);
            articlesDAO.articleCreate(articlesVO);

            return "redirect:/" + adminPath + "/board/articles/" + bm_seq + "/list";
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();

            rttr.addFlashAttribute("flag","error");
            rttr.addFlashAttribute(articlesVO);

            return "redirect:/" + adminPath + "/board/articles/" + bm_seq + "/create";
        }
    }
}
