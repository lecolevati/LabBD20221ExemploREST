package br.edu.fateczl.ExemploREST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "aluno")
//@NamedNativeQuery (
//		name = "aluno.udf",
//		query = "SELECT * FROM udf_aluno WHERE ra = ?1",
//		resultClass = Aluno.class
//		)
public class Aluno {

	@Id
	@Column(name = "ra", length = 13)
	@NonNull
	private String ra;

	@Column(name = "nome", length = 50)
	@NonNull
	private String nome;
	
	@Column(name = "email", length = 30)
	@NonNull
	private String email;
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + ", email=" + email + "]";
	}
}
