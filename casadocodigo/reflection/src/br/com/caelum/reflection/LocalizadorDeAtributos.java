package br.com.caelum.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LocalizadorDeAtributos {

	public List<String> buscaStringEmAtributos(Object o) {
		try {
			List<String> lista = new ArrayList<>();
			Class<?> c = o.getClass();
			for (Field f : c.getFields()) {
				System.out.println(f);
				Object value = f.get(o);
				if (value == null) {
					System.out.println(c.getFields());
					lista.add(f.getName());
				}
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
