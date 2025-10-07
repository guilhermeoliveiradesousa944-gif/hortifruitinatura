package projeto.maven.springboot.hortifruti.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import projeto.maven.springboot.hortifruti.model.UsuarioModel;
import projeto.maven.springboot.hortifruti.service.UsuarioService;


/**
 * 
 * @RestController
 * Esta anotação indica que a classe é um controlador REST, e que recebe uma requisições em HTTP (como o GET, POST, etc)
 * e retorna um texto
 * 
 * Um controlador intercepta todas as requisições feitas ao sistema
 * 
 * @RequestMapping
 * estou mapeando meu método para uma rota URL chamada value (value = "URL RAIZ /{nome}") e ainda estou passando 
 * por parâmetro, um argumento chamado "name"; a partir de então meu método se tornou um endpoint (um ponto de acesso);
 * Meu endpoint responde a requisições do tipo get e rotorna "Hello + nome!" - isso daqui é de um método padrão do spring boot;
 * porém já foi excluído.
 * 
 * @PathVariable 
 * Esta anotação pega as variáveis contidas na URL e as transformam em parâmetros para o método do controlador.
 * 
 * @ResponseStatus 
 * Esta anotação indica o status http que a aplicação var retornar. 
 *  
 *  @Autowired serve para injetar dependências
 *  
 *  ResponseEntity é uma classe do Spring Boot que controla o corpo da resposta (não requisiçaõ) e o status http
 * 
 */

@RestController
@RequestMapping("/usuario")//Define qual caminho (URL) será tratado por esta classe controladora ou método. 
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    //endpoint para listar produtos (GET - faz buscas)
    @GetMapping(value = "listar")/*faz a mesma coisa do @RequestMapping, porém já indica que o método irá responder a requisições HTTP GET*/
    @ResponseBody //retorna os dados no corpo da resposta (sem ser na URL - o corpo é como se fosse uma caixinha com os dados dentro) e geralmente em formato JSON
    public ResponseEntity<List<UsuarioModel>> listar(){
    	
    	List<UsuarioModel> usuarioModel = usuarioService.listarUsuario();//chamo a classe Service e seu método
    	
    	return new ResponseEntity<List<UsuarioModel>>(usuarioModel, HttpStatus.OK);//retorna a lista de objetos (isto é um fato), porém o @ResponseBody traduz para json antes de enviar no corpo da resposta
    	//lista de produtos são o corpo da resposta (os dados); HttpStatus é o status HTTP, que é 200 (ok)
    }
    
  //endpoint para salvar produtos (POST - cria novos recursos e os dados vão no corpo da requisição)
    @PostMapping(value = "salvar")
    @ResponseBody//retorna os dados no corpo da resposta (sem ser na URL - o corpo é como se fosse uma caixinha com os dados dentro) e geralmente em formato JSON
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuarioModel) {
    	
    	UsuarioModel usuario = usuarioService.salvarUsuario(usuarioModel);//chamo a classe Service e seu método
    	
    	return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.CREATED);//retorna um objeto (isto é um fato), porém o @ResponseBody traduz para json antes de enviar no corpo da resposta
   	 	//produto é  o corpo da resposta; HttpStatus é o status HTTP, que é 201 (created)
    }
    
  //endpoint para listar produtos pelo id (GET - faz buscas) 
   @GetMapping(value = "buscarPorId") 
   @ResponseBody //retorna os dados no corpo da resposta (sem ser na URL - o corpo é como se fosse uma caixinha com os dados dentro) e geralmente em formato JSON
   public ResponseEntity<?> buscarPorId(@RequestParam Long id){//@RequestParam recebe parâmetros que vêm na URL ou formulários que vêm no corpo de requisição
	   	/*O @RequestBody poderia ser usado neste caso, mas eu teria de substituir "Long id" por um objeto, e a partir deste objeto resgatar o id*/
	   
	   try {//vou validar a operação de buscarPorId; se der certo, retorno o objeto e o status http, mas se der errado, retorno a mensagem de erro que passei como parâmetro para a exceção
		   UsuarioModel usuarioModel = usuarioService.buscarUsuarioPorId(id);//chamo a classe Service e seu método
		   return ResponseEntity.status(HttpStatus.OK).body(usuarioModel);//retorna mue objeto no formato json, mais o status HTTP 200 (ok)
		   //retorno o objeto e o status http, como nos métodos anteriores. porém de um jeito diferente.
	   }catch(RuntimeException e) {
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());//retorna o status http 400 - bad_request; e retorna também o body, onde coloquei a mensagem de erro que passei como parâmetro para a exceção
	   }
    	
    }
   
   //endpoint para listar produtos pelo nome (GET - faz buscas)
   @GetMapping(value = "buscarPeloNome")
   @ResponseBody //retorna os dados no corpo da resposta (sem ser na URL - o corpo é como se fosse uma caixinha com os dados dentro) e geralmente em formato JSON 
   public ResponseEntity<List<UsuarioModel>> buscarPorNome(@RequestParam (name="nome")String nome){//@RequestParam recebe parâmetros que vêm na URL ou formulários que vêm no corpo de requisição
	   //(name = "nome") é para reforçar a informação
	   /*O @RequestBody poderia ser usado neste caso, mas eu teria de substituir "string nome" por um objeto, e a partir deste objeto resgatar o nome*/
	   
	   List<UsuarioModel> usuarioModel = usuarioService.buscarUsuarioPorNome(nome);//chamo a classe Service e seu método
	   
	   return ResponseEntity.ok(usuarioModel);
	 //retorno a lista de objetos e o status http, como nos métodos anteriores. porém de um jeito diferente.
   }
   
   
   //endpoint para deletar produtos (DELETE - remove um recurso existente)
   @DeleteMapping(value = "deletar")
   @ResponseBody //retorna os dados no corpo da resposta (sem ser na URL - o corpo é como se fosse uma caixinha com os dados dentro) e geralmente em formato JSON
   public ResponseEntity<String> deletar(@RequestParam Long id){//@RequestParam recebe parâmetros que vêm da URL, ou de formulários no corpo de requisição 
	   /*O @RequestBody poderia ser usado neste caso, mas eu teria de substituir "Long id" por um objeto, e a partir deste objeto resgatar o id*/
	   
	   try {
		   usuarioService.deletarProduto(id);//chamo a classe Service e seu método
		   return ResponseEntity.ok("Usuário deletado com sucesso!"); //retorno um String e o status http, como nos métodos anteriores. porém de um jeito diferente.
	   }catch(RuntimeException e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());//retorna o status http 404 - not found; e retorna também o body, onde coloquei a mensagem de erro que passei como parâmetro para a exceção
	   }
	   
   }
}
