package br.generation.grupo4.aMEI.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min=5, max=150)
	private String nome;
	
	@NotEmpty
	@Size(min=5, max=100)
	@Email
	private String email;

	@NotEmpty
	@Size(min=5, max=200)
	private String senha;
	
	@NotEmpty
	@Size(min=5, max=500)
	private String descricaoPerfil;
	
	@Column(name = "dt_nascimento")
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataNascimento; 
	
	private String foto;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("usuario")
    private List<Postagem> postagem;
	
	public Usuario() {}

	public Usuario(long id, String nome, String email, String senha, String descricaoPerfil,LocalDate datanascimento, String foto) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.descricaoPerfil = descricaoPerfil;
		this.dataNascimento = datanascimento;
		this.foto = foto;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}

	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	

}
