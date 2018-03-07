package com.adrianosantos.cursomc.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.adrianosantos.cursomc.dominio.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Integer idcliente;
	private String nmcliente;
	private String emailcliente;
	private String cpfOuCnpj;
	private Integer tipoCliente;

	@OneToMany(mappedBy="çliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection()
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {}

	public Cliente(Integer idcliente, String nmcliente, String emailcliente, String cpfOuCnpj, TipoCliente tipoCliente) {
		super();
		this.idcliente = idcliente;
		this.nmcliente = nmcliente;
		this.emailcliente = emailcliente;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipoCliente = tipoCliente.getCodtipocliente();
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNmcliente() {
		return nmcliente;
	}

	public void setNmcliente(String nmcliente) {
		this.nmcliente = nmcliente;
	}

	public String getEmailcliente() {
		return emailcliente;
	}

	public void setEmailcliente(String emailcliente) {
		this.emailcliente = emailcliente;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCodtipocliente();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcliente == null) ? 0 : idcliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (idcliente == null) {
			if (other.idcliente != null)
				return false;
		} else if (!idcliente.equals(other.idcliente))
			return false;
		return true;
	}


	
	
}
