package projeto.maven.springboot.hortifruti.model;

import java.io.Serializable;

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
@SequenceGenerator(name="seq_fornecedor", sequenceName="seq_fornecedor", allocationSize = 1, initialValue = 1)/*oame lógico do gerador; nome do gerador no banco de dados; aloca de 1 em 1; primeiro valor da sequência*/
@Table(name = "fornecedor_model")//indica para qual tabela no banco de dados esta classe entidade está mapeanda (no caso, ela corresponde a tabela "fornecedor_model" no banco de dados)
public class FornecedorModel implements Serializable /*padrão do java*/{
	
	private static final long serialVersionUID = 1L; //padrão do java

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fornecedor")
	private Long id;
	private String nome;
	private String telefone;
	private String cnpj;
	private String cidade;
	private String estado;
	private String bairro;
	private String logradouro;
	private String numero;
	private String cep;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
