package dto;

import java.util.Date;

public class PersonaDTO {
	private int idPersona;
	private int idDomicilio;
	private String nombre;
	private String telefono;
	private String email;
	private Date cumpleanios;
	private String etiqueta;
	private String destino;

	public PersonaDTO(int idPersona, int idDomicilio, String nombre, String telefono, String email, Date cumpleanios,
			String etiqueta, String destino) {
		this.idPersona = idPersona;
		this.idDomicilio = idDomicilio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.cumpleanios = cumpleanios;
		this.etiqueta = etiqueta;
		this.destino = destino;

	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public String setEmail(String email) {
		return this.email = email;
	}

	public Date getCumpleanios() {
		return this.cumpleanios;
	}
	
	public String getEtiqueta() {
		return this.etiqueta;
	}
	
	public String getDestino() {
		return this.destino;
	}

}
