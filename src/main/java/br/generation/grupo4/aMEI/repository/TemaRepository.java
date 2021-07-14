package br.generation.grupo4.aMEI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.generation.grupo4.aMEI.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository <Tema, Long> {
    public List <Tema> findAllByDescricaoContainingIgnoreCase (String descricao);
    public List <Tema> findAllByNomeContainingIgnoreCase (String nome);
    
    public Optional <Tema> findByDescricaoAndNome(String descricao, String nome);
    public List <Tema> findByDescricaoOrNome(String descricao, String nome);

}
