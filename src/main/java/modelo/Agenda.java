package modelo;

import java.util.List;

import dto.DomicilioDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.PersonaDAO;


public class Agenda 
{
	private PersonaDAO persona;
	private DomicilioDAO domicilio;
	
	public Agenda(DAOAbstractFactory metodoPersistencia)
	{
		this.persona = metodoPersistencia.createPersonaDAO();
		this.domicilio = metodoPersistencia.createDomicilioDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}
	

	public void borrarPersona(PersonaDTO personaAEliminar) 
	{
		this.persona.delete(personaAEliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	
	public void agregarDomicilio(DomicilioDTO nuevoDomicilio)
	{
		this.domicilio.insert(nuevoDomicilio);
	}

	public void borrarDomicilio(DomicilioDTO domicilioAEliminar) 
	{
		this.domicilio.delete(domicilioAEliminar);
	}
	
	public List<DomicilioDTO> obtenerDomicilios()
	{
		return this.domicilio.readAll();		
	}
}
