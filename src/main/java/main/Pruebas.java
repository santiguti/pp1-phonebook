package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import persistencia.conexion.Conexion;

public class Pruebas {
	public static Conexion instancia;
	private static  Connection connection;
	private static Logger log = Logger.getLogger(Conexion.class);	
	
	static void pruebas()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","root");
			connection.setAutoCommit(false);
			log.info("Conexión exitosa");
			Statement st = connection.createStatement();
			st.executeUpdate( 
			"INSERT INTO personas(Nombre, Telefono) VALUES ('pepe', 333456789);");
			connection.close();
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
		}
	}
	
	public static void hola() {
		System.out.println("Hola mundo");
	}
	
}
