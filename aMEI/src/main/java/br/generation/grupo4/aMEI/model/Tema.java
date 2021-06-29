package br.generation.grupo4.aMEI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity //SERA UMA ENTIDADE DO JPA
@Table(name = "tema") //CRIAÇÃO DA TABELA TEMA
public class Tema {
		

	@Id // ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO-INCREMENTO
	private long id;
	
	@NotNull
	private String nome;
	
	private String keyword;
	
	@NotNull
	private String descricao;
	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	
	

	

	
}
