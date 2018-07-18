package com.jordando.minesweeper.minesweeperbackend.controller;
import com.jordando.minesweeper.minesweeperbackend.model.MinesweeperGameModel;
import com.jordando.minesweeper.minesweeperbackend.repositories.MinesweeperRepository;
import com.jordando.minesweeper.minesweeperbackend.service.MinesweeperBackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MinesweeperBackendController {

    private MinesweeperBackendService minesweeperBackendService;

    MinesweeperRepository repo;

    public MinesweeperBackendController(MinesweeperBackendService minesweeperBackendService, MinesweeperRepository repo){
        this.minesweeperBackendService = minesweeperBackendService;
        this.repo = repo;
        if(null == repo.findGameByGameId("123")) {
            repo.save(new MinesweeperGameModel().builder().gameBoard("testGameBoard").gameId("123").moves("[xyz]").build());
            System.out.println("Put testdata into mongo");
        }
        else{
            System.out.println("Test data was present in mongo on startup");
        }
    }

    @GetMapping(value = "/logGame", headers = "Accept=application/json")
    public String respondToGet(){
        System.out.println("Received a get request");
        return "Get mappings dont really do anything here :)";
    }

    @GetMapping(value = "/logGame/{gameId}", headers = "Accept=application/json")
    public String respondToGetGame(@PathVariable String gameId){
        System.out.println("Received a get request for gameId " + gameId);
        return repo.findGameByGameId(gameId).toString();
    }

    @PostMapping(value = "/logGame", headers = "Accept=application/json")
    public String logGame(
            @RequestBody MinesweeperGameModel gameBoard) {
        System.out.println("Received post request");
        minesweeperBackendService.writeGameToMongo(gameBoard);
        repo.save(gameBoard);
        System.out.println(gameBoard.toString());
        return "{\"Message\":\"Request Received!\"}";
    }
}
