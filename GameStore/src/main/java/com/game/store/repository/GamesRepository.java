package com.game.store.repository;

import java.util.List;
import java.util.Optional;

import com.game.store.model.Game;
public class GamesRepository{
	
	private List<Game> games;
	
	public GamesRepository() {
		this.games = Database.getInstance().games();
	}
	public void cadastrar(Game game) {
		games.add(game);
	}
	public List<Game> obterTodos(){
		return games;
	}
	
	public void remover(int id) {
		games.remove(obterGame(id));
	}
	
	public Game obterGame(int id) {
		Optional<Game> gameEncontrado = games.stream().filter(p -> p.getId() == id).findFirst();
		return gameEncontrado.isPresent() ? gameEncontrado.get() : null;
	}
	
	public Game editar(Game game, int id) throws Exception {
		Game gameParaEditar = obterGame(id);
		
		if(gameParaEditar == null)
			throw new Exception("Game não existe");
		
		gameParaEditar.setTitulo(game.getTitulo());
		//gameParaEditar.setNumeroDeVendas(game.getNumeroDeVendas());
		
		return gameParaEditar;
	}
	
	public Game realizarVenda(Game game, int id) throws Exception {
		Game gameParaEditar = obterGame(id);
		
		if(gameParaEditar == null)
			throw new Exception("Game não existe");
		gameParaEditar.setNumeroDeVendas(game.getNumeroDeVendas());
		
		return gameParaEditar;
	}
	

}
