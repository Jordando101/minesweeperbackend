package com.jordando.minesweeper.minesweeperbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MinesweeperGameModel {
    private String gameBoard;
    private String moves;
    private String gameId;

    @Id
    private String mongoId;

    public String toString(){
        return String.format("MinesweeperGameModel[id=%s,gameBoard='%s', moves='%s']", this.gameId, this.gameBoard,  this.moves);
    }
}
