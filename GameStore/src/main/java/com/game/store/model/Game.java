package com.game.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Identificador único auto gerado")
	private int id;
	
	@NotEmpty(message = "O campo titulo é obrigatório")
	@ApiModelProperty(value = "Titulo do game")
	private String titulo;
	
	@NotEmpty(message = "O campo imagem é obrigatório")
	@ApiModelProperty(value = "Imagem do game")
	private String imagem;
	
	@NotNull(message = "O campo preco é obrigatório")
	@ApiModelProperty(value = "Preco do game")
	private double preco;
	
	@ApiModelProperty(value = "Numero de vendas do game")
	private int numeroDeVendas;
	
	
	public Game(int id, String titulo, String imagem, double preco, int numeroDeVendas) {
		this.id = id;
		this.titulo = titulo;
		this.imagem = imagem;
		this.preco = preco;
		this.numeroDeVendas = numeroDeVendas;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}
	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	/**
	 * @return the numeroDeVendas
	 */
	public int getNumeroDeVendas() {
		return numeroDeVendas;
	}
	/**
	 * @param numeroDeVendas the numeroDeVendas to set
	 */
	public void setNumeroDeVendas(int numeroDeVendas) {
		this.numeroDeVendas = numeroDeVendas;
	}
	
	

}
