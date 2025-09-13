package projeto.maven.springboot.hortifruti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.maven.springboot.hortifruti.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	@Query(value = "select p from ProdutoModel p where upper(trim(p.nome)) like %?1%") 	//like indica que quero pegar uma parte - %?1 é porque tenho apenas um parâmetro%
	List<ProdutoModel> pesquisarPorNome(String nome);										//trim retira o espaço
																						//upper coloca tudo em maísculo
}
