package kr.huny.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by sousic on 2016-09-09.
 */
public class PageInfoTest {
    PageInfo pageInfo = null;

    @Before
    public void setUp() throws Exception {
        pageInfo = new PageInfo();
    }

    @Test
    public void getStartPage() throws Exception {
        pageInfo.setPage(10);
        pageInfo.setPerPageNum(10);

        //System.out.println(pageInfo.getStartPage());
        Assert.assertThat(90, is(pageInfo.getStartPage()));
    }
}