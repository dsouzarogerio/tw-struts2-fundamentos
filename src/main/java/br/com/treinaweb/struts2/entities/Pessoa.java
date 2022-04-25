package br.com.treinaweb.struts2.entities;

import javax.persistence.*;

@Entity
@Table(name = "PES_PESSOAS")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PES_ID")
	private Integer id;
	
	@Column(name = "PES_NOME", nullable = false, length = 30)
	private String nome;
	
	@Column(name = "PES_IDADE", nullable = false)
	private Integer idade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
