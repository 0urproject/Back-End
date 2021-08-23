package br.generation.grupo4.aMEI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.generation.grupo4.aMEI.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	
	public Optional<Usuario> findByEmail(String login);
	
	public Usuario findByNome(String nome);

}
