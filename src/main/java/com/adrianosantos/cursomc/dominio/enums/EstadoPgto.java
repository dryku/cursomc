package com.adrianosantos.cursomc.dominio.enums;

public enum EstadoPgto {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private Integer codestadopgto;
	private String descricaoestadopgto;
	
	private EstadoPgto(Integer codestadopgto, String descricaoestadopgto) {
		this.codestadopgto = codestadopgto;
		this.descricaoestadopgto = descricaoestadopgto;
	}

	public Integer getCodestadopgto() {
		return codestadopgto;
	}

	public String getDescricaoestadopgto() {
		return descricaoestadopgto;
	}

	public static EstadoPgto toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for (EstadoPgto x : EstadoPgto.values()) {
			
			if (cod.equals(x.getCodestadopgto())) {
			return x;	
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}


}
