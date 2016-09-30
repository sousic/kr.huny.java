package kr.huny.controller.Sign;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.huny.service.LoginHistoryService;
import kr.huny.service.SignService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sousic on 2016-08-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/beans-context.xml"
})
@WebAppConfiguration
public class SignControllerTest {
    @Mock
    private SignService signService;
    @Mock
    private LoginHistoryService loginHistoryService;
    @Mock
    private SignInHelper signInHelper;
    @InjectMocks
    private SignController signController;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(signController).build();
    }

    @Test
    public void test_idChecker() throws Exception {
        mockMvc.perform(get("/sign/checker?userid=tests")).andExpect(status().isOk());
        String resultContent = mockMvc.perform(get("/sign/checker?userid=tests")).andReturn().getResponse().getContentAsString();

        Map<String, Object> result = new HashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        result = objectMapper.readValue(resultContent, Map.class);
        System.out.println(result.toString());

        Assert.assertThat(1, is(result.get("resultCode")));
    }

}