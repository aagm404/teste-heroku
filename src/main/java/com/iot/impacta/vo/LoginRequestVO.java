package com.iot.impacta.vo;

import java.io.Serializable;

public class LoginRequestVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String nome;
	public String digital;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDigital() {
		return digital;
	}
	
	public void setDigital(String digital) {
		this.digital = digital;
	}
}
