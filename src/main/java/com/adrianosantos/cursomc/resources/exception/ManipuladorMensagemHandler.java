package com.adrianosantos.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adrianosantos.cursomc.services.exceptions.DataIntegrityViolationExcep;
import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

@ControllerAdvice
public class ManipuladorMensagemHandler {

	@ExceptionHandler(ObjectNotFounException.class)
	public ResponseEntity<ErroPadrao> objetNotFound(ObjectNotFounException e, HttpServletRequest request) {

		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(DataIntegrityViolationExcep.class)
	public ResponseEntity<ErroPadrao> integridadeDados(DataIntegrityViolationExcep e, HttpServletRequest request) {

		ErroPadrao erro = new ErroPadrao(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroPadrao> validandoDados(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidaErro erro = new ValidaErro(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			erro.addErro(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

}