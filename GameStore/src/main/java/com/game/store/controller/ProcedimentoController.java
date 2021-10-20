package com.game.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.game.store.model.Game;
import com.game.store.repository.Database;

public class ProcedimentoController {
	@GetMapping
	public ResponseEntity<List<Game>> games(){
		Database bancoDeDados = Database.getInstance();

		bancoDeDados.games();
		return games();
	}

}
