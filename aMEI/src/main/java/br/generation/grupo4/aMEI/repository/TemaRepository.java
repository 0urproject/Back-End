package br.generation.grupo4.aMEI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.generation.grupo4.aMEI.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository <Tema, Long> {
    public List <Tema> findAllByDescricaoContainingIgnoreCase (String descricao);

}
