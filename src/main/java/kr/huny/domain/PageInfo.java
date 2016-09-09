package kr.huny.domain;

/**
 * Created by sousic on 2016. 9. 8..
 */
public class PageInfo {
    private int page;
    private int perPageNum;

    public PageInfo() {
        page = 1;
        perPageNum = 10;
    }
    public PageInfo(int pageSize)
    {
        this.page = pageSize;
    }

    public void setPage(int page)
    {
        if(page <= 0) {
            this.page = 1;
            return;
        }
        this.page = page;
    }

    public void setPerPageNum(int perPageNum) {
        if(perPageNum <= 0 || perPageNum > 100 ) {
            this.perPageNum = perPageNum;
        }
        this.perPageNum = perPageNum;
    }

    public int getPage() {
        return page;
    }

    public int getStartPage()
    {
        return (this.page - 1) * this.perPageNum;
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    @Override
    public String toString() {
        return "[PageInfo [page = " + this.page + ", perPageNum = " + this.perPageNum + "]";
    }
}
