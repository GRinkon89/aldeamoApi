package com.aldeamo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldeamo.model.ArraysEntity;
import com.aldeamo.repository.IListasRepository;

@Service
public class ListasService implements IListasService{
	
	@Autowired
	private IListasRepository listasRepository;
	
	List<ArraysEntity> listas;

	@Override
	public List<Integer> iterarListas(int iteraciones, int idPila) {
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listAux = new ArrayList<Integer>();
		listas = listasRepository.findAll();
		
		ArraysEntity pila = listasRepository.findById(idPila).get();
		listA = crearLista(pila);
		
		System.out.println("lista de BD "  + listA);
		
		List<Integer> listB;
		List<Integer> listP = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
		List<Integer> respuesta= new ArrayList<Integer>();
		int finPila = 0;
		int contador =0;
		iteraciones = iteraciones-1;
		

		for (int i = 0; i <= iteraciones; i++) {
			listB= new ArrayList<Integer>();
			listB = respuesta;
			listAux = new ArrayList<Integer>();
			System.out.println("--------------------------" );
			System.out.println("iteracion " + ++contador);
			ListIterator iter = listA.listIterator(listA.size());
			while (iter.hasPrevious()) {
				finPila = (int) iter.previous();
				if (finPila % listP.get(i) == 0) {
					
					System.out.println("numero " +finPila+"=  divisible");
					listB.add(finPila);
				}else {
					System.out.println("numero " +finPila);
					listAux.add(finPila);
					
				}
			}
			listA.clear();
			listA = listAux;
			respuesta = listB ;
			
			System.out.println("B "+ listB.toString());
			System.out.println("A"+contador+" "+listAux.toString());
			System.out.println("respuesta "+respuesta.toString());
		}
		if(listAux.size() > 0) {
			for (Integer numero : listAux) {
				respuesta.add(numero);
			}
		System.out.println("respuesta final"+respuesta.toString());
		}
		
		return respuesta;
	}
	
	private List<Integer> crearLista(ArraysEntity array){
						
		List<String> pila = Arrays.asList(array.getInputArray().split(","));
		List<Integer> pilaEnteros = new ArrayList<Integer>(); 
		for (String string : pila) {
			pilaEnteros.add(Integer.parseInt(string)); 
			
		}
		
		
		
		return pilaEnteros;
		
	}

}
