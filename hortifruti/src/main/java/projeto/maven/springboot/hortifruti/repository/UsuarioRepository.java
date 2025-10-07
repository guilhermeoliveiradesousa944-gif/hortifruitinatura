package projeto.maven.springboot.hortifruti.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projeto.maven.springboot.hortifruti.model.UsuarioModel;

/**
 * 
 * @Repository marca minha interface como um repositório; - Meu repositório é
 *             quem faz as operações com o banco de dados; - Transforma minha
 *             interface em uma bean, como outras anotaçõse fazem com suas
 *             classes(@Service, Controller, Entity)
 * 
 */

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	/**
	 * 
	 * Estou extendendo a interface JpaRepository<T, ID>, pois ela me oferece muitos
	 * recursos; UsuarioModel é minha classe persistente, que representa o banco de
	 * dados; Long é o tipo da chave primário (id é um Long)
	 * 
	 * @Query me permite fazer um comando sql personalizado;
	 * 
	 */

	@Query(value = "select p from UsuarioModel p where upper(trim(p.nome)) like %?1%") 	// like indica que quero pegar uma parte - %?1& é porque tenho apenas um parâmetro
	List<UsuarioModel> pesquisarPorNome(String nome); 									// trim retira o espaço
																						// upper coloca tudo em maísculo
}
