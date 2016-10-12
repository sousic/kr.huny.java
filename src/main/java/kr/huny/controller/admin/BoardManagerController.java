package kr.huny.controller.admin;

import kr.huny.Exceptions.LogException;
import kr.huny.controller.common.baseController;
import kr.huny.domain.PageInfo;
import kr.huny.domain.board.BoardManagerVO;
import kr.huny.service.BoardManagerService;
import kr.huny.utils.CookieHelper;
import kr.huny.utils.PagingHelper;
import kr.huny.utils.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by sousic on 2016-09-27.
 */
@Controller
@RequestMapping(value = "${adminPath}/board/manager")
public class BoardManagerController extends baseController {
    @Autowired
    BoardManagerService boardManagerService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model, PageInfo pageInfo)
    {
        PagingHelper pagingHelper = new PagingHelper(RequestHelper.getCurrentRequest());
        pagingHelper.setPageInfo(pageInfo);
        try {
            pagingHelper.setTotalCount(boardManagerService.boardManagerListCount(pageInfo));
            model.addAttribute("list", boardManagerService.boardManagerList(pageInfo));
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();
        }
        model.addAttribute("pagingHelper", pagingHelper);

        //logger.info(boardManagerDAO.boardManagerList(pageInfo).toString());
        logger.info(pagingHelper.toString());

        return "admin/board/manager/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model)
    {
        return "admin/board/manager/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createOK(BoardManagerVO boardManagerVO, Model model, RedirectAttributes rttr)
    {
        try {
            boardManagerVO.setWriter(CookieHelper.NickName(propertyHelper));
            boardManagerService.insertBoardManager(boardManagerVO);

            return "admin/board/manager/list";
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();

            rttr.addFlashAttribute("flag","error");
            rttr.addFlashAttribute(boardManagerVO);

            return "admin/board/manager/create";
        }
    }

    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public String modify(int seq, Model model)
    {
        BoardManagerVO boardManagerVO = null;

        try {
            boardManagerVO = boardManagerService.readBoardManager(seq);

            if (boardManagerVO == null) {
                return "admin/board/manager/list";
            }
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();
        }

        model.addAttribute(boardManagerVO);

        return "admin/board/manager/modify";
    }

    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public String modifyOK(BoardManagerVO boardManagerVO, Model model, RedirectAttributes rttr)
    {
        try {
            if(boardManagerVO != null) {
                boardManagerService.updateBoardManager(boardManagerVO);
            }
            return "admin/board/manager/list";
        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();

            rttr.addFlashAttribute("flag","error");
        }
        rttr.addFlashAttribute(boardManagerVO);
        return "admin/board/manager/modify";
    }
}
