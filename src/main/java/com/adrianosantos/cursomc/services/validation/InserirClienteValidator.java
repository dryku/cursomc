package com.adrianosantos.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.adrianosantos.cursomc.dominio.Cliente;
import com.adrianosantos.cursomc.dominio.enums.TipoCliente;
import com.adrianosantos.cursomc.dto.ClienteCadastroDTO;
import com.adrianosantos.cursomc.repositorios.ClienteRepositorio;
import com.adrianosantos.cursomc.resources.exception.CampoMensagem;
import com.adrianosantos.cursomc.services.validation.utils.BR;

public class InserirClienteValidator implements ConstraintValidator<InserirCliente, ClienteCadastroDTO> {

	@Autowired
	ClienteRepositorio clirep;
	
	@Override
	public void initialize(InserirCliente ann) {
	}

	@Override
	public boolean isValid(ClienteCadastroDTO objDto, ConstraintValidatorContext context) {
		List<CampoMensagem> list = new ArrayList<>();

		if (objDto.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCodtipocliente())
				&& !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new CampoMensagem("cpfOuCnpj", "CPF Inválido"));
		}

		if (objDto.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.getCodtipocliente())
				&& !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new CampoMensagem("cpfOuCnpj", "CNPJ Inválido"));
		}
		
//		System.out.println("Emai do cliente a ser enviado:\n" + objDto.getEmailcliente() +"\n\n");
		
		Cliente aux = clirep.findByEmailcliente(objDto.getEmailcliente());
		
		if (aux != null) {
			list.add(new CampoMensagem("Emailcliente", "E-mail: " + objDto.getEmailcliente() + " já existe!!"));			
		}
	
		for (CampoMensagem e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getCampo())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}