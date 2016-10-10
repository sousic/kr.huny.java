package kr.huny.controller.admin;

import kr.huny.Exceptions.LogException;
import kr.huny.controller.common.baseController;
import kr.huny.domain.PageInfo;
import kr.huny.domain.board.ArticlesVO;
import kr.huny.persistence.board.ArticlesDAO;
import kr.huny.persistence.board.BoardManagerDAO;
import kr.huny.utils.CookieHelper;
import kr.huny.utils.PagingHelper;
import kr.huny.utils.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private String boardTitle = null;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam("bm_seq") long bm_seq, Model model, PageInfo pageInfo)
    {
        PagingHelper pagingHelper = new PagingHelper(RequestHelper.getCurrentRequest(), "bm_seq");
        pagingHelper.setPageInfo(pageInfo);

        model.addAttribute("bm_seq", bm_seq);

        try {
            //게시물 타이틀 추출
            boardTitle = boardManagerDAO.GetBoardIdToTitle(bm_seq);
            pagingHelper.setTotalCount(articlesDAO.articlesListCount(pageInfo));
            //목록조회
            List<ArticlesVO> newList = new ArrayList<ArticlesVO>();
            newList.addAll(articlesDAO.articlesListNotice());
            newList.addAll(articlesDAO.articlesList(pageInfo));

            model.addAttribute("list", newList);

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
            articlesVO.setWriter(CookieHelper.NickName(propertyHelper));
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

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String view(ArticlesVO articlesVO, Model model)
    {
        model.addAttribute("bm_seq", articlesVO.getBm_seq());

        try
        {
            //게시물 타이틀 추출
            boardTitle = boardManagerDAO.GetBoardIdToTitle(articlesVO.getBm_seq());
            model.addAttribute("boardTitle", boardTitle);
            model.addAttribute(articlesDAO.articleView(articlesVO));

            return "admin/board/articles/read";
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();

            return "redirect:/" + adminPath +"/board/articles/list?bm_seq="+articlesVO.getBm_seq();
        }
    }

    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public String modify(ArticlesVO articlesVO, Model model)
    {
        model.addAttribute("bm_seq", articlesVO.getBm_seq());

        try
        {
            boardTitle = boardManagerDAO.GetBoardIdToTitle(articlesVO.getBm_seq());
            model.addAttribute("boardTitle", boardTitle);
            model.addAttribute(articlesDAO.articleView(articlesVO));
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();

            return "redirect:/" + adminPath + "/board/articles/view?bm_seq="+ articlesVO.getBm_seq() + "&seq="+ articlesVO.getSeq();
        }

        return "admin/board/articles/modify";
    }

    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public String modifyOK(ArticlesVO articlesVO, Model model, RedirectAttributes rttr)
    {
        model.addAttribute("bm_seq", articlesVO.getBm_seq());

        try {
            articlesDAO.articleModify(articlesVO);

            return "redirect:/" + adminPath +"/board/articles/view?bm_seq="+ articlesVO.getBm_seq() + "&seq="+ articlesVO.getSeq();
        }
        catch (Exception ex) {
            new LogException(ex).printStackTrace();

            rttr.addFlashAttribute("flag", "error");
            rttr.addFlashAttribute(articlesVO);

            return "redirect:/" + adminPath + "/board/articles/modify?bm_seq="+ articlesVO.getBm_seq() + "&seq="+ articlesVO.getSeq();
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(ArticlesVO articlesVO)
    {
        try {
            articlesDAO.articleDelete(articlesVO);
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();
        }

        return "redirect:/" + adminPath + "/board/articles/modify?bm_seq="+ articlesVO.getBm_seq();
    }

    @RequestMapping(value = "uploadImage", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    public @ResponseBody Map<String, Object> uploadImage(MultipartFile upladdFile)
    {
        resultJson = new HashMap<String, Object>();
        resultJson.put("resultCode", 1);
        resultJson.put("resultMsg", "성공");
        resultJson.put("url", "http://t1.daumcdn.net/news/201610/10/yonhap/20161010102839387yxey.jpg");

        return resultJson;
    }
}
