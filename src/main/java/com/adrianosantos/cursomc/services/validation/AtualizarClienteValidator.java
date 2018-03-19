package com.adrianosantos.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.adrianosantos.cursomc.dominio.Cliente;
import com.adrianosantos.cursomc.dto.ClienteDTO;
import com.adrianosantos.cursomc.repositorios.ClienteRepositorio;
import com.adrianosantos.cursomc.resources.exception.CampoMensagem;

public class AtualizarClienteValidator implements ConstraintValidator<AtualizarCliente, ClienteDTO> {

	@Autowired
	private ClienteRepositorio clirep;

	@Autowired
	private HttpServletRequest request;

	@Override
	public void initialize(AtualizarCliente ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		Integer uriId = Integer.parseInt(map.get("id"));

		List<CampoMensagem> list = new ArrayList<>();

		Cliente aux = clirep.findByEmailcliente(objDto.getEmailcliente());

		if (aux != null && !aux.getIdcliente().equals(uriId)) {
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