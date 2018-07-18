package com.jordando.minesweeper.minesweeperbackend.service;

import com.jordando.minesweeper.minesweeperbackend.model.MinesweeperGameModel;
import org.springframework.stereotype.Service;

@Service
public class MinesweeperBackendService {

    public boolean writeGameToMongo(MinesweeperGameModel game){
        return true;
    }
}
