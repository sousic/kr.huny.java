package kr.huny.utils;

import kr.huny.domain.PageInfo;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sousic on 2016-09-20.
 */
public class PagingHelper {
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayPageNum = 10;

    private PageInfo pageInfo;

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;

        calcPage();
    }

    private void calcPage() {
        endPage = (int)(Math.ceil(pageInfo.getPage() / (double)displayPageNum) * displayPageNum);

        startPage = (endPage - displayPageNum) + 1;

        int tempEndPage = (int)(Math.ceil(totalCount / (double)pageInfo.getPerPageNum()));

        if(endPage > tempEndPage)
        {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false : true;
        next = endPage * pageInfo.getPerPageNum() >= totalCount ? false : true;
    }

    private String makeQuery(HttpServletRequest request, int page)
    {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .build();
        return String.format("%s%s",request.getAttribute("javax.servlet.forward.request_uri"), uriComponents.toString()); //
    }

    public String printPaging(HttpServletRequest request)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("<ul class=\"pagination\">");
        //prev buttton
        String strPrevUrl = isPrev() == false ? "#" : makeQuery(request, startPage-1);
        sb.append(String.format("<li><a href=\"%s\">Prev</a></li>", strPrevUrl));

        //page button
        for(int i = startPage; i <=endPage; i++)
        {
            sb.append(String.format("<li %s><a href=\"%s\">%s</a></li>", (i == pageInfo.getPage() ? "class=\"active\"" : ""), makeQuery(request, i), i));
        }

        String strNextUrl = isNext() == false ? "#" : makeQuery(request, endPage+1);
        sb.append(String.format("<li><a href=\"%s\">Next</a></li>", strNextUrl));
        sb.append("</ul>");
        return sb.toString();
    }


    public int getTotalCount() {
        return totalCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    @Override
    public String toString() {
        return "PagingHelper{" +
                "totalCount=" + totalCount +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", displayPageNum=" + displayPageNum +
                ", pageInfo=" + pageInfo +
                '}';
    }
}
