package com.game.store.repository;

import java.util.ArrayList;
import java.util.List;

import com.game.store.model.*;
public class Database {
	
	private static Database instancia;
	
	private List<Game> games = new ArrayList<Game>();
	
	public static Database getInstance() {
		if(instancia == null ) {
			instancia = new Database();
		}
		
		return instancia;
	}
	public List<Game> games()
	{
		return games;
	}
	
}
