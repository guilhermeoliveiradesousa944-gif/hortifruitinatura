package projeto.maven.springboot.hortifruti.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import projeto.maven.springboot.hortifruti.model.ProdutoModel;
import projeto.maven.springboot.hortifruti.service.ProdutoService;


@RestController
public class ProdutoController {
    
    @Autowired
    ProdutoService produtoService;
    
    @GetMapping(value = "listar")
    @ResponseBody
    public ResponseEntity<List<ProdutoModel>> listar(){
    	
    	List<ProdutoModel> produtoModel = produtoService.listarUsuarios();
    	
    	return new ResponseEntity<List<ProdutoModel>>(produtoModel, HttpStatus.OK);
    	
    }
    
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<ProdutoModel> salvar(@RequestBody ProdutoModel produtoModel) {
    	
    	ProdutoModel produto = produtoService.salvarUsuario(produtoModel);
    	
    	return new ResponseEntity<ProdutoModel>(produto, HttpStatus.CREATED);
    	
    }
    
   @PostMapping(value = "buscarPorId") 
   @ResponseBody
   public ResponseEntity<?> buscarPorId(@RequestParam Long id){
    	
	   try {
		   ProdutoModel produtoModel = produtoService.buscarUsuarioPorId(id);
		   return ResponseEntity.status(HttpStatus.OK).body(produtoModel);
	   }catch(RuntimeException e) {
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	   }
    	
    }
   
   @PostMapping(value = "buscarPeloNome")
   @ResponseBody
   public ResponseEntity<List<ProdutoModel>> buscarPorNome(@RequestParam (name="nome")String nome){
	   
	   List<ProdutoModel> produtoModel = produtoService.buscarUsuarioPorNome(nome);
	   
	   return ResponseEntity.ok(produtoModel);
	   
   }
   
   @DeleteMapping(value = "deletar")
   @ResponseBody
   public ResponseEntity<String> deletar(Long id){
	   
	   try {
		   produtoService.deletarUsuario(id);
		   return ResponseEntity.ok("Produto deletado com sucesso!");
	   }catch(RuntimeException e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	   }
	   
   }
}
