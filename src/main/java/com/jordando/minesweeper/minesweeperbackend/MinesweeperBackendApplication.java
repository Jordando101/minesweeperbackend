package com.jordando.minesweeper.minesweeperbackend;

import com.jordando.minesweeper.minesweeperbackend.model.MinesweeperGameModel;
import com.jordando.minesweeper.minesweeperbackend.repositories.MinesweeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinesweeperBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(MinesweeperBackendApplication.class, args);
	}
}

