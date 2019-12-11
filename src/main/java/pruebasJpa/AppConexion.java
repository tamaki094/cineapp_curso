package pruebasJpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConexion 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml"); //Creamos una  instancia del [applicationContext] de SPRING  utulizando la implementacion [ClassPath...], lee la configuracion de los BEANS desde un archivo XML.
	
		context.close();

	}

}
