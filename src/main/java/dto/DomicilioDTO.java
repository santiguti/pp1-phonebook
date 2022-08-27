package dto;

public class DomicilioDTO
{
	private int idDomicilio;
	private int idPersona;
	private String calle;
	private int altura;
	private int piso;
	private String depto;
	private String provincia;
	private String localidad;
	
	public DomicilioDTO()
	{
		
	}
	
	public DomicilioDTO(int idDomicilio, int idPersona, String calle, int altura, int piso, String depto, String provincia, String localidad) 
	{
		this.setIdDomicilio(idDomicilio);
		this.setIdPersona(idPersona);
		this.setCalle(calle);
		this.setAltura(altura);
		this.setPiso(piso);
		this.setDepto(depto);
		this.setProvincia(provincia);
		this.setLocalidad(localidad);
	}
	
	public int getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}


	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

}
