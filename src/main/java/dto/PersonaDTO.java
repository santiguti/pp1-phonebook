package dto;

import java.util.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	//Agrego Calle, numero, piso y depto por separado
	private String calle;
	private String numeroCalle;
	private String piso;
	//private char depto; no se que tipo de dato es el depto
	private Domicilio domicilio;
	private String email;
	private Date cumpleanios;

	public PersonaDTO(int idPersona, String nombre, String telefono, Domicilio domicilio, String email, Date cumpleanios, 
			String calle, String numeroCalle, String piso) //puse la altura y el piso en string para ahorrar parseos
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
		this.cumpleanios = cumpleanios;
		this.calle = calle;
		this.numeroCalle = numeroCalle;
		this.piso = piso;
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
	
	//agrego setters y getters de calle, numero, piso
	
	public String getCalle() {
		return this.calle;
	}
	
	public String getNumeroCalle() {
		return this.numeroCalle;
	}
	
	public String getPiso() {
		return this.piso;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public void setNumerCalle(String numeroCalle) {
		this.numeroCalle = numeroCalle;
	}
	
	public void setPiso(String piso) {
		this.piso = piso;
	}
}
