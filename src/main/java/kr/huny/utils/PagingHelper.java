package kr.huny.utils;

import kr.huny.domain.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sousic on 2016-09-20.
 */
@Component
public class PagingHelper {
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayPageNum = 10;

    private PageInfo pageInfo;

    private HttpServletRequest request;

    private MultiValueMap<String, String> extendParameters;

    public PagingHelper() {
        this.prev = false;
        this.next = false;
        this.totalCount = 0;
        this.startPage = 0;
        this.endPage = 0;
    }

    /**
     * 페이징 네비게이터 생성자
     * @param request - 스프링 mvc request
     * @param args - 추가 필요 querystring paramters 추가 ex) "test", "test" ...
     */
    public PagingHelper(HttpServletRequest request, String... args) {
        this();

        InitExtendParameters(request, args);
    }

    @Autowired
    public PagingHelper(HttpServletRequest request)
    {
        this();

        this.request = request;
    }

    private void InitExtendParameters(HttpServletRequest request, String[] args) {
        this.request = request;

        extendParameters = new LinkedMultiValueMap<String, String>();

        //추가 파라메터값 세팅
        if(args.length > 0) {
            for(String key : args) {
                if(StringUtils.isEmpty(request.getParameter(key)) == false) {
                    extendParameters.add(key, request.getParameter(key));
                }
            }
        }
    }

    /**
     * 추가 파라메터값 추출 ( view 용 )
     * @param key 추출할 키값
     * @return "" or 키값
     */
    public String getExtendParameterValue(String key)
    {
        if(extendParameters != null)
        {
            if(extendParameters.containsKey(key))
            {
                return extendParameters.getFirst(key).toString();
            }
            return "";
        }
        return "";
    }

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
                .queryParam("perPageNum", pageInfo.getPerPageNum())
                .queryParam("schText", pageInfo.getSchText())
                .queryParams(this.extendParameters)
                .build();

        //return String.format("%s%s",this.request.getAttribute("javax.servlet.forward.request_uri"), uriComponents.toString()); //
        return String.format("%s%s",this.request.getRequestURI(), uriComponents.toString());
    }

    public String printPaging(HttpServletRequest request)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("<ul class=\"pagination\">");
        //prev buttton
        String strPrevUrl = isPrev() == false ? "#" : makeQuery(request, startPage-1);
        sb.append(String.format("<li><a href=\"%s\">Prev</a></li>", strPrevUrl));

        //page button
        if(startPage == 1 && endPage == 0)
        {
            sb.append(String.format("<li %s><a href=\"%s\">%s</a></li>", "class=\"active\"", makeQuery(request, 1), 1));
        }
        else
        {
            for (int i = startPage; i <= endPage; i++) {
                sb.append(String.format("<li %s><a href=\"%s\">%s</a></li>", (i == pageInfo.getPage() ? "class=\"active\"" : ""), makeQuery(request, i), i));
            }
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
