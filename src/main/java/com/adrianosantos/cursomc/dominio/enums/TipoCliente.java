package com.adrianosantos.cursomc.dominio.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Fisica"), 
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private Integer codtipocliente;
	private String descricaotipocliente;
	
	private TipoCliente(Integer codtipocliente, String descricaotipocliente) {
		this.codtipocliente = codtipocliente;
		this.descricaotipocliente = descricaotipocliente;
	}

	public Integer getCodtipocliente() {
		return codtipocliente;
	}

	public String getDescricaotipocliente() {
		return descricaotipocliente;
	}

	public static TipoCliente toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			
			if (cod.equals(x.getCodtipocliente())) {
			return x;	
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
