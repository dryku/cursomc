package com.adrianosantos.cursomc.resources.exception;

import org.apache.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adrianosantos.cursomc.services.exceptions.ObjectNotFounException;

@ControllerAdvice
public class ManipuladorMensagemHandler {

	@ExceptionHandler(ObjectNotFounException.class)
	public ResponseEntity<ErroPadrao> objetNotFound(ObjectNotFounException e, HttpRequest request){

	ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
}
}