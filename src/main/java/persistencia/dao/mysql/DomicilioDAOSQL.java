package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DomicilioDAO;
import dto.DomicilioDTO;

public class DomicilioDAOSQL implements DomicilioDAO
{
	//cada vez que hay un campo nuevo hay que colocarlo en el statement
	private static final String insert = "INSERT INTO domicilios(idDomicilio, Calle, Altura, Piso, Depto, Pais, Provincia, Localidad) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM domicilios WHERE idDomicilio = ?";
	private static final String readall = "SELECT * FROM domicilios";
		
	public boolean insert(DomicilioDTO domicilio)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, domicilio.getIdDomicilio());
			statement.setString(2, domicilio.getCalle());
			statement.setInt(3, domicilio.getAltura());
			statement.setInt(4, domicilio.getPiso());
			statement.setString(5, domicilio.getDepto());
			statement.setString(6, domicilio.getPais());
			statement.setString(7, domicilio.getProvincia());
			statement.setString(8, domicilio.getLocalidad());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(DomicilioDTO domicilio_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(domicilio_a_eliminar.getIdDomicilio()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<DomicilioDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<DomicilioDTO> domicilios = new ArrayList<DomicilioDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				domicilios.add(getDomicilioDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return domicilios;
	}
	
	private DomicilioDTO getDomicilioDTO(ResultSet resultSet) throws SQLException
	{
		int idDomicilio = resultSet.getInt("idDomicilio");
		String calle = resultSet.getString("Calle");
		int altura = resultSet.getInt("Altura");
		int piso = resultSet.getInt("Piso");
		String depto = resultSet.getString("Depto");
		String pais = resultSet.getString("Pais");
		String provincia = resultSet.getString("Provincia");
		String localidad = resultSet.getString("Localidad");
		return new DomicilioDTO(idDomicilio, calle, altura, piso, depto, pais, provincia, localidad);
	}
}
