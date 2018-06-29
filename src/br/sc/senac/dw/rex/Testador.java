package br.sc.senac.dw.rex;

import java.lang.reflect.Field;

import br.sc.senac.dw.rex.db.model.entity.Pessoa;

public class Testador {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		
		Field[] campos = p.getClass().getDeclaredFields();
		for (Field field : campos) {
			field.setAccessible(true);
			System.out.println(field.getName());
		}
	}

}
