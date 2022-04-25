package br.com.treinaweb.struts2.controllers;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import br.com.treinaweb.struts2.entities.Pessoa;
import br.com.treinaweb.struts2.services.PessoaService;

public class PessoaController extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6910136550216389876L;

	// bean para inserir pessoa
	private Pessoa pessoa;

	// bean para listar pessoas
	private List<Pessoa> pessoas;

	// bean para mensagem de erro eventual
	private String mensagemErro;
	
	//bean para pesquisar pessoa por nome
	private List<Pessoa> pessoasPorNome;

	/*
	 * M�todo(action) para inseir pessoa
	 */
	public String inserirPessoa() {
		return "OK";
	}

	/*
	 * M�todo(action) para listar pessoas
	 */
	public String listar() {
		try {
			PessoaService ps = new PessoaService();
			this.pessoas = ps.listarPessoas();
			return SUCCESS;
		} catch (Exception e) {
			this.mensagemErro = e.getMessage();
			return ERROR;
		}
	}

	/*
	 * M�todo(action) para mostrar pessoa por id
	 */
	public String mostrar() {
		try {
			int id = Integer.parseInt(ActionContext.getContext().getParameters().get("id").getValue());
			PessoaService ps = new PessoaService();
			this.pessoa = ps.byId(id);
			return SUCCESS;
		} catch (Exception e) {
			this.mensagemErro = e.getMessage();
			return ERROR;
		}
	}

	/*
	 * M�todo(action) para inserir pessoa
	 */
	public String inserir() {
		try {
			PessoaService ps = new PessoaService();
			ps.inserirPessoa(this.pessoa);
			return SUCCESS;
		} catch (Exception e) {
			this.mensagemErro = e.getMessage();
			return ERROR;
		}
	}
	
	/*
	 * M�todo(action) para pesquisar pessoa por Nome
	 */
	public String pesquisarPessoaPorNome() {
		PessoaService ps = new PessoaService();
		String nome = ActionContext.getContext().getParameters().get("nome").getValue();
		this.pessoasPorNome = ps.pesquisarPessoaPorNome(nome);
		return SUCCESS;
	}

	/*
	 * M�todo validate() para valida��o dos campos do formul�rio
	 */
	@Override
	public void validate() {
		if (this.pessoa != null) {
			if (this.pessoa.getNome() == "") {
				addFieldError("pessoa.nome", "O nome � obrigat�rio.");
			}
			if (this.pessoa.getNome().length() < 3) {
				addFieldError("pessoa.nome", "O nome deve conter no m�nimo 3 caracteres.");
			}
			if (this.pessoa.getIdade() == null) {
				addFieldError("pessoa.idade", "A idade deve ser um n�mero v�lido.");
			}
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public List<Pessoa> getPessoasPorNome() {
		return pessoasPorNome;
	}

}
