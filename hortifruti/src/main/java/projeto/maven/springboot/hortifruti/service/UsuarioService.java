package projeto.maven.springboot.hortifruti.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.maven.springboot.hortifruti.model.UsuarioModel;
import projeto.maven.springboot.hortifruti.repository.UsuarioRepository;

/**
 * 
 * @Service é usada para marcar uma classe como um componente de serviço — ou seja, uma classe que contém regras de negócio da aplicação.
 * 
 * @Autowired serve para injetar dependências
 * 
 * */

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<UsuarioModel> listarUsuario(){
		
		List<UsuarioModel> usuarioModel = usuarioRepository.findAll();//executa e consulta no banco de dados
		//1: O método findAll() é chamado.
    	//2: O Spring Data JPA gera queries SQL automaticamente. - Spring Data JPA(Java Persistense API) forcene interfaces e métodos prontos para realizar operaçõse com o banco de dados 
    	//3: O banco retorna os registros.
    	//4: Cada registro é convertido em um objeto ProdutoModel.
    	//5: A lista de objetos é atribuída à variável produtoModel.
		
		return usuarioModel;
		
	}
	
	public UsuarioModel salvarUsuario(UsuarioModel usuario) {
		
		UsuarioModel usuarioModel = usuarioRepository.save(usuario);//salva meus dados no banco
		
		return usuarioModel;
		
	}
	
	public UsuarioModel buscarUsuarioPorId(Long id){
		
		try {//se der certo, retorno o objeto; se não, lanço uma execção e uma mensagem explicando o erro
			UsuarioModel usuarioModel = usuarioRepository.findById(id).get();//busca usuário pelo ID
			return usuarioModel;
		}catch(RuntimeException e) {
			throw new RuntimeException("O produto com o ID " + id + " não existe!");//no bloco try, retorno é um objeto, já no bloco catch, retorno uma String - por isso do retorno genêrico do entpoint 
		}
		
	}
	
	public List<UsuarioModel> buscarUsuarioPorNome(String nome){
		
		List<UsuarioModel> usuarioModel = usuarioRepository.pesquisarPorNome(nome.trim().toUpperCase());//busca usuário pelo nome - trim() retira o espaço
		
		return usuarioModel;
		
	}
	
	public void deletarProduto(Long id) {
		
		if(!usuarioRepository.existsById(id)) {//se usuário com tal id não existir, então lanço uma exceção
			throw new RuntimeException("O produto com o ID " + id + " não existe!");
		}else {
			usuarioRepository.deleteById(id);//deleta meu usuário no banco, através do ID
		}
		
	}

}
