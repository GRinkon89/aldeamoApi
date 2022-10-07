package com.aldeamo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aldeamo.dto.EntradaDTO;
import com.aldeamo.service.IListasService;

@RestController
public class ListasController {
	
	@Autowired
	IListasService listasService;
	
	@PostMapping(value = "iterar")
	public ResponseEntity<String> iterarListas(@RequestBody EntradaDTO entradaDto){
		List<Integer> respuesta = new ArrayList<Integer>();
		respuesta= listasService.iterarListas(entradaDto.getIteraciones(), entradaDto.getIdPila());
		if (respuesta != null) {
			return ResponseEntity.ok(respuesta.toString());
		}else {
			return ResponseEntity.badRequest()
            .body("Numero de pila no permitido, solo se permite de 1 a 5");
		}
		
		
		
	}

}
