package com.jordando.minesweeper.minesweeperbackend.service;

import com.jordando.minesweeper.minesweeperbackend.model.MinesweeperGameModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MinesweeperBackendServiceTest {

    private MinesweeperGameModel game = MinesweeperGameModel.builder().build();

    private MinesweeperBackendService minesweeperBackendService;

    @Before
    public void setUp(){
        minesweeperBackendService = new MinesweeperBackendService();
    }

    @Test
    public void minesweeperBackendService_shouldReturnTrue(){
        assertTrue(minesweeperBackendService.writeGameToMongo(game));
    }
}