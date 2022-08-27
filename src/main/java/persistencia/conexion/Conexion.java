package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);	
	
	private Conexion()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","root");
			this.connection.setAutoCommit(false);
			log.info("Conexión exitosa");
			//Statement st = connection.createStatement();
			String sql = "INSERT INTO personas(Nombre, Telefono) VALUES ('pepe', 333456789, 'blandengues', 78,2);";
			//st.executeUpdate( );
			PreparedStatement preparedStmt = connection.prepareStatement(sql);
			//preparedStmt.setString(1, s.nombre);
			preparedStmt.execute();
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
}
