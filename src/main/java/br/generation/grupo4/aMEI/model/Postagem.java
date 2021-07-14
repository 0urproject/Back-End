package br.generation.grupo4.aMEI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min=5, max=255)
	private String titulo;
	
	@NotEmpty
	@Size(min=5, max=500)
	private String descricaoPost;
	
	@NotEmpty
	@Size(min=5, max=500)
	private String imgpost;

	private String hashtag;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties({"postagem", "senha"})
	private Usuario usuario;
	
	@PositiveOrZero
	private int curtidas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public String getDescricaoPost() {
		return descricaoPost;
	}

	public void setDescricaoPost(String descricaoPost) {
		this.descricaoPost = descricaoPost;
	}

	public String getImgpost() {
		return imgpost;
	}

	public void setImgpost(String imgpost) {
		this.imgpost = imgpost;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}
}
