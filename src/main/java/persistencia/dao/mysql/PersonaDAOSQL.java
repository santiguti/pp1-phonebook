package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO {
	// cada vez que hay un campo nuevo hay que colocarlo en el statement
	private static final String insert = "INSERT INTO personas(idPersona, idDomicilio, Nombre, Telefono, Email, Cumpleanios) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";

	public boolean insert(PersonaDTO persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setInt(2, persona.getIdDomicilio());
			statement.setString(3, persona.getNombre());
			statement.setString(4, persona.getTelefono());
			statement.setString(5, persona.getEmail());

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, persona.getCumpleanios().getYear() + 1900);
			cal.set(Calendar.MONTH, persona.getCumpleanios().getMonth());
			cal.set(Calendar.DATE, persona.getCumpleanios().getDay());
			java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
			System.out.println("SQL DATE: " + sqlDate);
			System.out.println("GETYEAR PERSONA" + persona.getCumpleanios().getYear() + 1900);
			statement.setDate(6, sqlDate);
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isInsertExitoso;
	}

	public boolean delete(PersonaDTO persona_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	public List<PersonaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				personas.add(getPersonaDTO(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}

	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException {
		int idPersona = resultSet.getInt("idPersona");
		int idDomicilio = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String email = resultSet.getString("Email");
		Date cumpleanios = resultSet.getDate("Cumpleanios");
		return new PersonaDTO(idPersona, idDomicilio, nombre, tel, email, cumpleanios);
	}
}
