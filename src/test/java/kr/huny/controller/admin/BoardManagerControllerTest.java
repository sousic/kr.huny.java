package kr.huny.controller.admin;

import kr.huny.persistence.board.BoardManagerDAO;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sousic on 2016-09-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/beans-context.xml"
})
//@TestPropertySource(value = {"file:src/main/resources/config/config.properties"})
@WebAppConfiguration
public class BoardManagerControllerTest {
    @Mock
    BoardManagerDAO boardManagerDAO;
    @InjectMocks
    private BoardManagerController boardManagerController;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(boardManagerController).build();
    }

    @Test
    public void list() throws Exception {
        mockMvc.perform(get("/a/board/manager/list")).andExpect(status().isOk());
    }

    //@Test
    public void create() throws Exception {

    }

    //@Test
    public void createOK() throws Exception {

    }

    //@Test
    public void modify() throws Exception {

    }

}