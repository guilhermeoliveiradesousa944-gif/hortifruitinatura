package projeto.maven.springboot.hortifruti.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.maven.springboot.hortifruti.model.FornecedorModel;
import projeto.maven.springboot.hortifruti.repository.FornecedorRepository;


/**
 * 
 * @Service é usada para marcar uma classe como um componente de serviço — ou seja, uma classe que contém regras de negócio da aplicação.
 * 
 * @Autowired serve para injetar dependências
 * 
 * */

@Service
public class FornecedorService {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	public List<FornecedorModel> listarFornecedor(){
		
		List<FornecedorModel> fornecedorModel = fornecedorRepository.findAll();//executa e consulta no banco de dados
		//1: O método findAll() é chamado.
    	//2: O Spring Data JPA gera queries SQL automaticamente. - Spring Data JPA(Java Persistense API) forcene interfaces e métodos prontos para realizar operaçõse com o banco de dados 
    	//3: O banco retorna os registros.
    	//4: Cada registro é convertido em um objeto ProdutoModel.
    	//5: A lista de objetos é atribuída à variável produtoModel.
		
		return fornecedorModel;
		
	}
	
	public FornecedorModel salvarFornecedor(FornecedorModel usuario) {
		
		FornecedorModel fornecedorModel = fornecedorRepository.save(usuario);//salva meus dados no banco
		
		return fornecedorModel;
		
	}
	
	public FornecedorModel buscarFornecedorPorId(Long id){
		
		try {//se der certo, retorno o objeto; se não, lanço uma execção e uma mensagem explicando o erro
			FornecedorModel fornecedorModel = fornecedorRepository.findById(id).get();//busca usuário pelo ID
			return fornecedorModel;
		}catch(RuntimeException e) {
			throw new RuntimeException("O fornecedor com o ID " + id + " não existe!");//no bloco try, retorno é um objeto, já no bloco catch, retorno uma String - por isso do retorno genêrico do entpoint 
		}
		
	}
	
	public List<FornecedorModel> buscarFornecedorPorNome(String nome){
		
		List<FornecedorModel> fornecedorModel = fornecedorRepository.pesquisarPorNome(nome.trim().toUpperCase());//busca usuário pelo nome - trim() retira o espaço
		
		return fornecedorModel;
		
	}
	
	public void deletarFornecedor(Long id) {
		
		if(!fornecedorRepository.existsById(id)) {//se usuário com tal id não existir, então lanço uma exceção
			throw new RuntimeException("O fornecedor com o ID " + id + " não existe!");
		}else {
			fornecedorRepository.deleteById(id);//deleta meu usuário no banco, através do ID
		}
		
	}

}
