package br.generation.grupo4.aMEI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.generation.grupo4.aMEI.model.Postagem;
import br.generation.grupo4.aMEI.repository.PostagemRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository repository;
	
	private Postagem buscarPostagemPorId (Long id) {
		
		Postagem buscarPostagemPorId = repository.findById(id).orElse(null);
	
		if (buscarPostagemPorId != null) {
			return buscarPostagemPorId;
			
		}else{
			throw new EmptyResultDataAccessException(1);
		}
	}
	public Postagem curtir (Long id) {
		Postagem postagem = buscarPostagemPorId (id);
		postagem.setCurtidas(postagem.getCurtidas() + 1);
		
		return repository.save (postagem);
	}
	public Postagem descurtir (Long id) {
		Postagem postagem = buscarPostagemPorId (id);
		postagem.setCurtidas(postagem.getCurtidas() - 1);
		
		if (postagem.getCurtidas() > 0) {
			postagem.setCurtidas(postagem.getCurtidas() - 1);
			
		} else {
			postagem.setCurtidas(0);
		}
		
		return repository.save (postagem);
	}
}