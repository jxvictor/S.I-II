package com.game.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.game.store.model.Game;
import com.game.store.model.Response;
import com.game.store.repository.Database;
import com.game.store.repository.GamesRepository;
import com.sun.net.httpserver.Authenticator.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@CrossOrigin()
@RestController
@RequestMapping(path = "/v2/game", produces = "application/json")
public class GamesMelhoradoController {
	
	private GamesRepository gamesRepository;
	public GamesMelhoradoController() 
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
	public ResponseEntity<Response<List<Game>>> obterTodos(){		
		
		Response<List<Game>> response = new Response<List<Game>>();
		
		try
		{
			response.setDados(gamesRepository.obterTodos());
			response.setStatus(HttpStatus.OK.value());
			
			return ResponseEntity.ok(response);
		}
		catch(Exception e)
		{
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao cadastrar novo game");
			
			return ResponseEntity.ok(response);
		}
	}
	@GetMapping("/{id}")
	public Response<Game> obterPorId(@PathVariable int id){		
		
		Response<Game> response = new Response<Game>();
		
		try
		{
			response.setDados(gamesRepository.obterGame(id));
			response.setStatus(HttpStatus.OK.value());
			
			return response;
		}
		catch(Exception e)
		{
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao obter o game");
			
			return response;
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
	public ResponseEntity<Response<Game>> cadastrar(@Valid @RequestBody Game game, BindingResult result)
	{	
		Response<Game> response = new Response<Game>(); 
		
		try
		{		
			if(result.hasErrors())
			{			
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				for(ObjectError  error : result.getAllErrors()) {
					String key = String.valueOf(response.getErros().size() + 1);
					
					response.getErros().put(key, error.getDefaultMessage());
				}
				
				return ResponseEntity.ok(response);
			}
			
			response.setStatus(HttpStatus.OK.value());
			gamesRepository.cadastrar(game);		
			response.setDados(game);
			
			return ResponseEntity.ok(response);
			
		}
		catch(Exception e) {	
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao cadastrar novo game");
			
			return ResponseEntity.ok(response);
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
	public ResponseEntity<Response<Game>> deletar(@PathVariable int id){
		
		Response<Game> response = new Response<Game>(); 
		
		
		try
		{	
			response.setStatus(HttpStatus.OK.value());
			gamesRepository.remover(id);
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao remover game");
			return ResponseEntity.ok(response);
		}
	}
	
	
	/*@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable int id){
		
		Response<String> response = new Response<String>();
		
		
		try
		{
			gamesRepository.remover(id);
			return new ResponseEntity<String>("Game removido com sucesso", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
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
	public ResponseEntity<Response<Game>> editar(@PathVariable int id, @Valid @RequestBody Game game, BindingResult result){
		
		Response<Game> response = new Response<Game>(); 
		
		try {
			if(result.hasErrors())
			{			
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				for(ObjectError  error : result.getAllErrors()) {
					String key = String.valueOf(response.getErros().size() + 1);
					
					response.getErros().put(key, error.getDefaultMessage());
				}
				
				return ResponseEntity.ok(response);
			}
			response.setStatus(HttpStatus.OK.value());
			response.setDados(gamesRepository.editar(game, id));
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao editar game");
			return ResponseEntity.ok(response);
		}
	}
}