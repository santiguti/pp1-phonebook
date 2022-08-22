package dto;

import java.util.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private Domicilio domicilio;
	private String email;
	private Date cumpleanios;

	public PersonaDTO(int idPersona, String nombre, String telefono, Domicilio domicilio, String email, Date cumpleanios)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
		this.cumpleanios = cumpleanios;
	}
	
	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	public Domicilio getDomicilio() 
	{
		return this.domicilio;
	}

	public void setDomicilio(Domicilio domicilio) 
	{
		this.domicilio = domicilio;
	}
}
