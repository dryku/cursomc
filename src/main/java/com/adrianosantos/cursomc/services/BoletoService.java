package com.adrianosantos.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.adrianosantos.cursomc.dominio.PgtoBoleto;

@Service
public class BoletoService {

	public void preencherPgtoBoleto(PgtoBoleto pgto, Date dtapedido){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dtapedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pgto.setDtavencimento(cal.getTime());
	}
}
