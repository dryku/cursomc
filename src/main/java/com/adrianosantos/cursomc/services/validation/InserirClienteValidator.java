package com.adrianosantos.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.adrianosantos.cursomc.dominio.enums.TipoCliente;
import com.adrianosantos.cursomc.dto.ClienteCadastroDTO;
import com.adrianosantos.cursomc.resources.exception.CampoMensagem;
import com.adrianosantos.cursomc.services.validation.utils.BR;

public class InserirClienteValidator implements ConstraintValidator<InserirCliente, ClienteCadastroDTO> {
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
		
		
		for (CampoMensagem e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getCampo())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}