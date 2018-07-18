package com.jordando.minesweeper.minesweeperbackend.repositories;

import java.util.List;

import com.jordando.minesweeper.minesweeperbackend.model.MinesweeperGameModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MinesweeperRepository  extends MongoRepository<MinesweeperGameModel, String>{
    public MinesweeperGameModel findGameByGameId(String gameId);
}
