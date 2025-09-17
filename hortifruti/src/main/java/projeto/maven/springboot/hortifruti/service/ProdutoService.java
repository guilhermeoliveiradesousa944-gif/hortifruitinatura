package projeto.maven.springboot.hortifruti.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.maven.springboot.hortifruti.model.ProdutoModel;
import projeto.maven.springboot.hortifruti.repository.ProdutoRepository;

/**
 * 
 * @Service é usada para marcar uma classe como um componente de serviço — ou seja, uma classe que contém regras de negócio da aplicação.
 * 
 * @Autowired serve para injetar dependências
 * 
 * */

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<ProdutoModel> listarUsuarios(){
		
		List<ProdutoModel> produtoModel = produtoRepository.findAll();//executa e consulta no banco de dados
		//1: O método findAll() é chamado.
    	//2: O Spring Data JPA gera queries SQL automaticamente. - Spring Data JPA(Java Persistense API) forcene interfaces e métodos prontos para realizar operaçõse com o banco de dados 
    	//3: O banco retorna os registros.
    	//4: Cada registro é convertido em um objeto ProdutoModel.
    	//5: A lista de objetos é atribuída à variável produtoModel.
		
		return produtoModel;
		
	}
	
	public ProdutoModel salvarUsuario(ProdutoModel produto) {
		
		ProdutoModel produtoModel = produtoRepository.save(produto);//salva meus dados no banco
		
		return produtoModel;
		
	}
	
	public ProdutoModel buscarUsuarioPorId(Long id){
		
		try {//se der certo, retorno o objeto; se não, lanço uma execção e uma mensagem explicando o erro
			ProdutoModel produtoModel = produtoRepository.findById(id).get();//busca usuário pelo ID
			return produtoModel;
		}catch(RuntimeException e) {
			throw new RuntimeException("O produto com o ID " + id + " não existe!");//no bloco try, retorno é um objeto, já no bloco catch, retorno uma String - por isso do retorno genêrico do entpoint 
		}
		
	}
	
	public List<ProdutoModel> buscarUsuarioPorNome(String nome){
		
		List<ProdutoModel> produtoModel = produtoRepository.pesquisarPorNome(nome.trim().toUpperCase());//busca usuário pelo nome - trim() retira o espaço
		
		return produtoModel;
		
	}
	
	public void deletarUsuario(Long id) {
		
		if(!produtoRepository.existsById(id)) {//se usuário com tal id não existir, então lanço uma exceção
			throw new RuntimeException("O produto com o ID " + id + " não existe!");
		}else {
			produtoRepository.deleteById(id);//deleta meu usuário no banco, através do ID
		}
		
	}

}
