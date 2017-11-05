package gal.caronte.sw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gal.caronte.sw.manager.MuseoManager;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-contexto.xml");
		for (String a : context.getBeanDefinitionNames()) {
			System.out.println(a);
		}
		
		MuseoManager museoManager = (MuseoManager) context.getBean("museoManagerImpl");
		museoManager.getTodosEdificios();
		System.out.println("Hello World!");
	}
}
