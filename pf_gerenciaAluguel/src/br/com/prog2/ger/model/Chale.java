package br.com.prog2.ger.model;

import java.math.BigDecimal;

public class Chale {
	int codChale;
	String localizacao;
	int capacidade;
	BigDecimal valorAltaEstação;
	BigDecimal valorBaixaEstação;
	
	
	public int getCodChale() {
		return codChale;
	}
	public void setCodChale(int codChale) {
		this.codChale = codChale;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public BigDecimal getValorAltaEstacao() {
		return valorAltaEstação;
	}
	public void setValorAltaEstacao(BigDecimal valorAltaEstação) {
		this.valorAltaEstação = valorAltaEstação;
	}
	public BigDecimal getValorBaixaEstacao() {
		return valorBaixaEstação;
	}
	public void setValorBaixaEstacao(BigDecimal valorBaixaEstação) {
		this.valorBaixaEstação = valorBaixaEstação;
	}
	
	
}
