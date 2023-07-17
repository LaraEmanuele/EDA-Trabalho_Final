package br.com.prog2.ger.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Hospedagem {
	int codHospedagem;
	int codChale;
	String estado;
	Date dataInicio;
	Date dataFim;
	int qtdPessoas;
	double desconto;
	BigDecimal valorFinal;
	public int getCodHospedagem() {
		return codHospedagem;
	}
	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}
	public int getCodChale() {
		return codChale;
	}
	public void setCodChale(int codChale) {
		this.codChale = codChale;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = Date.valueOf(dataInicio);
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = Date.valueOf(dataFim);
	}
	public int getQtdPessoas() {
		return qtdPessoas;
	}
	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
	
}
