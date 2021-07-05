package br.generation.grupo4.aMEI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.generation.grupo4.aMEI.model.Postagem;

@Repository
public interface PostagemRepository  extends JpaRepository<Postagem,Long>{
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	public List<Postagem> findAllByHashtagContainingIgnoreCase(String hashtag);

}
