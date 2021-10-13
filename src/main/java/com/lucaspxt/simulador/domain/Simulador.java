package com.lucaspxt.simulador.domain;

import java.io.Serializable;

public class Simulador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double taxa;
	private Integer parcelas;
	private Double valor;
	
	public Simulador(Double taxa, Integer parcelas, Double valor) {
		super();
		this.taxa = taxa;
		this.parcelas = parcelas;
		this.valor = valor;
	}
	public Double getTaxa() {
		return taxa;
	}
	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	public Integer getParcelas() {
		return parcelas;
	}
	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parcelas == null) ? 0 : parcelas.hashCode());
		result = prime * result + ((taxa == null) ? 0 : taxa.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Simulador other = (Simulador) obj;
		if (parcelas == null) {
			if (other.parcelas != null)
				return false;
		} else if (!parcelas.equals(other.parcelas))
			return false;
		if (taxa == null) {
			if (other.taxa != null)
				return false;
		} else if (!taxa.equals(other.taxa))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	

}
