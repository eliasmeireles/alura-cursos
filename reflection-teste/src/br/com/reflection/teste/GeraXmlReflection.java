package br.com.reflection.teste;

import java.lang.reflect.Field;

public class GeraXmlReflection {
	
	public static String verificador(Object obj) throws Exception {
		StringBuilder builder = new StringBuilder();
		
		Class<?> clazz = obj.getClass();
		builder.append("<" + clazz.getSimpleName() + "> \n");
		
		for (Field f: clazz.getDeclaredFields()) {
			builder.append("<" + f  + "> \n");
			
			f.setAccessible(true);

			
			builder.append(f.get(obj));
			
			builder.append("</" + f.getName() + "> \n");
		}
		
		builder.append("</" + clazz.getSimpleName() + "> \n");
		
		return builder.toString();
		
	}
}
