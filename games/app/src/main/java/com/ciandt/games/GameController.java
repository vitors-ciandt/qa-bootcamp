package com.ciandt.games;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "amazonaws.com", "localhost" })
@RestController
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping("/play")
    public Game play() {
        return service.play();
    }

    @GetMapping("/play-from-bottom")
    public Game playFromTheBottom() {
        return service.playFromTheBottom();
    }

    @GetMapping("/games")
    public List<Game> findAll() {
        return service.findAll();
    }
}
