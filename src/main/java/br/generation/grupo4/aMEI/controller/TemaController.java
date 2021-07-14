package br.generation.grupo4.aMEI.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.generation.grupo4.aMEI.model.Tema;
import br.generation.grupo4.aMEI.repository.TemaRepository;



@RestController
@RequestMapping("/temas")
@CrossOrigin("*")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>>GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Tema>> getByNome (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> getByDescricao (@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@GetMapping("/descricao/{descricao}/nome/{nome}")
	public ResponseEntity<List<Tema>> getByDescricaoAndNome (@PathVariable String descricao, @PathVariable String nome){
		return ResponseEntity.ok(repository.findByDescricaoOrNome(descricao, nome));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id) {
		return repository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping ("/postar")
	public ResponseEntity<Tema> post (@RequestBody Tema temas){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(temas));
	}
	@PutMapping ("/editar")
	public ResponseEntity<Tema> put (@RequestBody Tema temas){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(temas));
	}
	@DeleteMapping ("/deletar/{id}")
	public void deleteTema (@PathVariable long id) {
		repository.deleteById(id);
	}
}
