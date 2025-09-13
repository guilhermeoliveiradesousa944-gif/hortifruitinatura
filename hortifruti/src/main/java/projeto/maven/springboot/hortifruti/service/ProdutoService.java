package projeto.maven.springboot.hortifruti.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.maven.springboot.hortifruti.model.ProdutoModel;
import projeto.maven.springboot.hortifruti.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<ProdutoModel> listarUsuarios(){
		
		List<ProdutoModel> produtoModel = produtoRepository.findAll();
		
		return produtoModel;
		
	}
	
	public ProdutoModel salvarUsuario(ProdutoModel produto) {
		
		ProdutoModel produtoModel = produtoRepository.save(produto);
		
		return produtoModel;
		
	}
	
	public ProdutoModel buscarUsuarioPorId(Long id){
		
		try {
			ProdutoModel produtoModel = produtoRepository.findById(id).get();
			return produtoModel;
		}catch(RuntimeException e) {
			throw new RuntimeException("O produto com o ID " + id + " não existe!");
		}
		
	}
	
	public List<ProdutoModel> buscarUsuarioPorNome(String nome){
		
		List<ProdutoModel> produtoModel = produtoRepository.pesquisarPorNome(nome.trim().toUpperCase());
		
		return produtoModel;
		
	}
	
	public void deletarUsuario(Long id) {
		
		if(!produtoRepository.existsById(id)) {
			throw new RuntimeException("O produto com o ID " + id + " não existe!");
		}else {
			produtoRepository.deleteById(id);
		}
		
	}

}
