package kr.huny.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;

/**
 * Created by sousic on 2016-08-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class PropertyHelperTest {

    @Autowired
    protected PropertyHelper propertyHelper;

    @Test
    public void test_loginFailLimitCount() throws Exception {
        int loginFailLImitCount = 3;

        Assert.assertThat(3, is(loginFailLImitCount));
    }
}