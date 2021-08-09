package br.generation.grupo4.aMEI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.generation.grupo4.aMEI.model.Usuario;
import br.generation.grupo4.aMEI.model.UsuarioLogin;
import br.generation.grupo4.aMEI.repository.UsuarioRepository;
import br.generation.grupo4.aMEI.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());	
	}	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id) {
		return usuarioRepository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());				
	}	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> autenticationUsuario(@RequestBody Optional<UsuarioLogin> usuariologin) {
		return usuarioService.logarUsuario(usuariologin)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());	
	}	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		
		Usuario newUser = usuarioService.cadastrarUsuario(usuario);
		
		try {
			return ResponseEntity.ok(newUser);
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().build();
		}				
	}
	@PutMapping("/alterar")
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario) {
		
		Optional<Usuario> updateUser = usuarioService.atualizarUsuario(usuario); 
		try {
			return ResponseEntity.ok(updateUser.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}		
	}	
}