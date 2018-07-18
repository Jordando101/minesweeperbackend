package com.jordando.minesweeper.minesweeperbackend.controller;

import com.jordando.minesweeper.minesweeperbackend.service.MinesweeperBackendService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringRunner.class)
@WebAppConfiguration
public class MinesweeperBackendControllerTest {

    private MockMvc mvc;
    private String path = "/logGame";
    private String mockGamePostBody = "{\"gameBoard\": \"[[x,x,x],[x,x,x],[x,x,x]]\"," +
                                         " \"moves\": \"[[1,1], [2,2], [3,3]]\"}";


//    private String mockGamePostBody = "{\n" +
//            "\t\"gameBoard\": \"Just a string\"\n" +
//            "}";

    @Mock
    MinesweeperBackendService mockmMinesweeperBackendService;

    private MinesweeperBackendController minesweeperBackendController;

//    @Autowired
//    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {

        minesweeperBackendController = new MinesweeperBackendController(mockmMinesweeperBackendService);
        mvc = standaloneSetup(minesweeperBackendController).build();
    }

    @Test
    public void minesweeperBackendController_shouldReturn200AndMessageOnGetRequest(){

    }


    @Test
    public void minesweeperBackendController_shouldReturn200() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                                                .get(path)
                                                .accept(MediaType.APPLICATION_JSON)
                                                .content(mockGamePostBody)
                                                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request).andExpect(status().isOk());
    }


    @Test
    public void minesweeperBackendController_shouldCallMineSweeperServiceMethods() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                                                .post(path)
                                                .accept(MediaType.APPLICATION_JSON)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(mockGamePostBody);

        mvc.perform(request)
                .andExpect(status().isOk());
        verify(mockmMinesweeperBackendService).writeGameToMongo(any());


    }

}