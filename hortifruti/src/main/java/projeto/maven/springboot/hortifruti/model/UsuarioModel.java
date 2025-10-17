package projeto.maven.springboot.hortifruti.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @Entity marca minha classe como uma entidade, e faz dela uma tabela no banco de dados
 * @id marca minha variável como uma chave primária
 * @SequenceGenerator cria uma sequência 
 * @GeneratedValue indica que o valor da compo anotado (no caso o id), terá seu valor gerado automaticamente
 * 
 * */

@Entity
@SequenceGenerator(name="seq_usuario", sequenceName="seq_usuario", allocationSize = 1, initialValue = 1)/*nome lógico do gerador; nome do gerador no banco de dados; aloca de 1 em 1; primeiro valor da sequência*/
@Table(name = "usuario_model")//indica para qual tabela no banco de dados esta classe entidade está mapeanda (no caso, ela corresponde à tabela "usuario_model" no banco de dados)
public class UsuarioModel implements Serializable /*padrão do java*/{
	
	private static final long serialVersionUID = 1L; //padrão do java

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;
	private int idade;
	private String nome;
	private String sobrenome;
	private String sexo;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
