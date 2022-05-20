package br.edu.fateczl.ExemploREST.model.entity;

import java.io.Serializable;

public class MatriculaRelatorioPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String raAluno;
	private int codigoDisicplina;
	
	public String getRaAluno() {
		return raAluno;
	}
	public void setRaAluno(String raAluno) {
		this.raAluno = raAluno;
	}
	public int getCodigoDisicplina() {
		return codigoDisicplina;
	}
	public void setCodigoDisicplina(int codigoDisicplina) {
		this.codigoDisicplina = codigoDisicplina;
	}
	
	@Override
	public String toString() {
		return "MatriculaRelatorioPK [raAluno=" + raAluno + ", codigoDisicplina=" + codigoDisicplina + "]";
	}

}
