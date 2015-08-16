import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloWorldApplication.class)
@WebAppConfiguration("server.port:0")
public class MyRestControllerTest {

	 @Autowired
	 private WebApplicationContext webApplicationContext;
	 
	 private MockMvc mockMvc;
	
	@Before
    public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
	}

	@Test
	public void testRequest() throws Exception {
		mockMvc.perform(get("/"))
                        .andExpect(status().isOk())
                        .andExpect(content().string("Hello World!"));
	}
	
}
