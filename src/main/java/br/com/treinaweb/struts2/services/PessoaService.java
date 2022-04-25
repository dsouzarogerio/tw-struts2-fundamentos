package br.com.treinaweb.struts2.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinaweb.struts2.entities.Pessoa;
import br.com.treinaweb.struts2.utils.JpaUtils;

public class PessoaService {
	/*
	 * Método para listar pessoas
	 */
	public List<Pessoa> listarPessoas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pessoas = em.createQuery("from Pessoa", Pessoa.class).getResultList();
			return pessoas;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/*
	 * Método para selecionar pessoa por Id
	 */
	public Pessoa byId(Integer id) {
		Pessoa resultado = new Pessoa();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			resultado = em.find(Pessoa.class, id);
			return resultado;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/*
	 * Método para inserir pessoa
	 */
	public void inserirPessoa(Pessoa p) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/*
	 * Método para pesquisar pessoa por nome
	 */
	public List<Pessoa> pesquisarPessoaPorNome(String nome) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			List<Pessoa> resultado = em
					.createQuery("from Pessoa p where lower(p.nome) like lower(concat('%', :nome, '%'))", Pessoa.class)
					.setParameter("nome", nome).getResultList();
			return resultado;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
