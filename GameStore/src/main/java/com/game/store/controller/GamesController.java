package com.game.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.game.store.model.*;
import com.game.store.repository.GamesRepository;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping(path = "/v1/game", produces = "application/json")

public class GamesController {
	
	private GamesRepository gamesRepository;
	
	public GamesController() 
	{
		this.gamesRepository = new GamesRepository();
	}
	
	@ApiOperation(value = "Retorna todos os games cadastrados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	
	@GetMapping()
	public ResponseEntity<List<Game>> obterTodos(){		
		try
		{
			return new ResponseEntity<List<Game>>(gamesRepository.obterTodos(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<List<Game>>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Cadastra um game novo")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 201, message = "Criado"),
			@ApiResponse(code = 401, message = "Não autorizado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PostMapping()
	public ResponseEntity<String> cadastrar(@RequestBody Game game)
	{
		try
		{
			gamesRepository.cadastrar(game);
			return new ResponseEntity<String>("Game cadastrado com sucesso", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@ApiOperation(value = "Deleta um game por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 204, message = "Sem conteúdo"),
			@ApiResponse(code = 401, message = "Não autorizado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable int id){
		try
		{
			gamesRepository.remover(id);
			return new ResponseEntity<String>("Game removido com sucesso", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Edita um game por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 201, message = "Criado"),
			@ApiResponse(code = 401, message = "Não autorizado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Game> editar(@PathVariable int id, @RequestBody Game game){
		try {
			Game gameEditado = gamesRepository.editar(game, id);
			return new ResponseEntity<Game>(gameEditado, HttpStatus.OK); 
		}
		catch(Exception e) {
			return new ResponseEntity<Game>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Realiza a venda de um game por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "Endpoint não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PostMapping("/vendas/{id}")
	public void realizarVenda(Game game, @PathVariable int id) {
		int realizeiVenda = 0;
		for (int i = 0; i <= realizeiVenda; i++) {
			game.setNumeroDeVendas(i++);
		}
	}
	
}
