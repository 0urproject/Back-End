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

import br.generation.grupo4.aMEI.model.Postagem;
import br.generation.grupo4.aMEI.repository.PostagemRepository;
import br.generation.grupo4.aMEI.service.PostagemService;



@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@Autowired
	private PostagemService service;
	
	@GetMapping
	public ResponseEntity<List<Postagem>>GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo (@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	@GetMapping("/hashtag/{hashtag}")
	public ResponseEntity<List<Postagem>> getByHashtag (@PathVariable String hashtag){
		return ResponseEntity.ok(repository.findAllByHashtagContainingIgnoreCase(hashtag));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id) {
		return repository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping ("/postar")
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagens){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagens));
	}
	@PutMapping ("/editar")
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagens){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagens));
	}
	@DeleteMapping ("/deletar/{id}")
	public void deletePostagem (@PathVariable long id) {
		repository.deleteById(id);
	}
	@PutMapping ("/likes/{id}")
	public Postagem curtir (@PathVariable long id ) {
		return service.curtir(id);
	}
	@PutMapping ("/dislikes/{id}")
	public Postagem descurtir (@PathVariable long id ) {
		return service.descurtir(id);
	}
}