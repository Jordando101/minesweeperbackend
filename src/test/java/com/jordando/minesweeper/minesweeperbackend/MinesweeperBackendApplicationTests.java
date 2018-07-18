package com.jordando.minesweeper.minesweeperbackend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.Mockito.*;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MinesweeperBackendApplicationTests {

	private MockMvc mockmvc;
	private String path = "/loggame";

	@Before
	public void startup(){
	}

	@Test
	public void contextLoads() {
	}



}
