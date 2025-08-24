package com.devsuperior.dslist.controllers;

import java.util.HashMap;
import java.util.List;

import org.hibernate.engine.internal.Collections;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.repositories.GameRepository;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private final GameRepository gameRepository;
	
	@Autowired
	private GameService gameService;

    GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
	
	@GetMapping
	@RequestMapping("/gamemin")
	public List<GameMinDTO> findAllGameMin(){
		List<GameMinDTO> result = gameService.findAllGameMin();
		return result;
	}
	
	@GetMapping
	@RequestMapping("/game")
	public List<GameDTO> findAllGame(){
		List<GameDTO> result = gameService.findAllGame();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable("id") Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}
	
}
