package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaEditar;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.DomicilioDTO;
import dto.PersonaDTO;

public class Controlador implements ActionListener {
	private Vista vista;
	private List<PersonaDTO> personasEnTabla;
	private List<DomicilioDTO> domiciliosEnTabla;
	private VentanaPersona ventanaPersona;
	private VentanaEditar ventanaEditar;
	private Agenda agenda;
	private int filaSeleccionadaAEditar;

	public Controlador(Vista vista, Agenda agenda) {
		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(a -> ventanaAgregarPersona(a));
		this.vista.getBtnEditar().addActionListener(k -> ventanaEditarPersona(k));
		this.vista.getBtnBorrar().addActionListener(s -> borrarPersona(s));
		this.vista.getBtnReporte().addActionListener(r -> mostrarReporte(r));
		this.ventanaPersona = VentanaPersona.getInstance();
		this.ventanaEditar = VentanaEditar.getInstance();
		this.ventanaPersona.getBtnAgregarPersona().addActionListener(p -> guardarPersona(p));
		this.ventanaEditar.getBtnEditarPersona().addActionListener(b -> editarPersona(b));
		this.agenda = agenda;
	}

	private void ventanaAgregarPersona(ActionEvent a) {
		this.ventanaPersona.mostrarVentana();
	}

	private void ventanaEditarPersona(ActionEvent k) {
		filaSeleccionadaAEditar = this.vista.getTablaPersonas().getSelectedRow();
		if (filaSeleccionadaAEditar != -1) {
			this.ventanaEditar.mostrarVentana();
			List<PersonaDTO> personas = agenda.obtenerPersonas();
			this.ventanaEditar.setTxtNombre(personas.get(filaSeleccionadaAEditar).getNombre());
			this.ventanaEditar.setTxtTelefono(personas.get(filaSeleccionadaAEditar).getTelefono());
			this.ventanaEditar.setTxtEmail(personas.get(filaSeleccionadaAEditar).getEmail());
			Calendar cal = Calendar.getInstance();
			cal.setTime(personas.get(filaSeleccionadaAEditar).getCumpleanios());
			
			this.ventanaEditar.setDiaCumple(cal.get(Calendar.DAY_OF_MONTH));
			this.ventanaEditar.setMesCumple(cal.get(Calendar.MONTH)+1);
			this.ventanaEditar.setAnioCumple(cal.get(Calendar.YEAR));
			
		}
	}

	private void guardarPersona(ActionEvent p) {

		String calle = this.ventanaPersona.getTxtCalle().getText();
		int altura =  this.ventanaPersona.getAltura();
		int piso = this.ventanaPersona.getPiso();
		String depto = this.ventanaPersona.getTxtDepto().getText();
		String pais = this.ventanaPersona.getComboPais();
		String provincia = this.ventanaPersona.getComboProv();
		String localidad = this.ventanaPersona.getComboLocal();
		DomicilioDTO nuevoDomicilio = new DomicilioDTO(0, calle, altura, piso, depto, pais, provincia, localidad);
		this.agenda.agregarDomicilio(nuevoDomicilio);

		// Guardo todos los domicilios para poder tomar el ultimo domicilio creado DESDE
		// mysql
		// para poder tomar el id automatico que se le asignó a ese domicilio
		List<DomicilioDTO> domicilios = agenda.obtenerDomicilios();
		int domicilioId = domicilios.get(domicilios.size() - 1).getIdDomicilio();

		String nombre = this.ventanaPersona.getTxtNombre().getText();
		String tel = this.ventanaPersona.getTxtTelefono().getText();
		String email = this.ventanaPersona.getTxtEmail().getText();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, this.ventanaPersona.getAnioCumple());
		cal.set(Calendar.MONTH, this.ventanaPersona.getMesCumple()-1);
		cal.set(Calendar.DATE, this.ventanaPersona.getDiaCumple());
		Date cumpleanios = new Date(cal.getTimeInMillis());
		String etiqueta = this.ventanaPersona.getComboEtiqueta();
		String destino = this.ventanaPersona.getComboDestino();
		PersonaDTO nuevaPersona = new PersonaDTO(0, domicilioId, nombre, tel, email, cumpleanios, etiqueta, destino);
		this.agenda.agregarPersona(nuevaPersona);
		this.refrescarTabla();
		this.ventanaPersona.cerrar();
	}

	private void editarPersona(ActionEvent b) {
		List<PersonaDTO> personas = agenda.obtenerPersonas();
		int personaId = personas.get(filaSeleccionadaAEditar).getIdPersona();
		int domicilioId = personas.get(filaSeleccionadaAEditar).getIdDomicilio();
		
		
		String nombre = this.ventanaEditar.getTxtNombre().getText();
		String tel = this.ventanaEditar.getTxtTelefono().getText();
		String email = this.ventanaEditar.getTxtEmail().getText();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, this.ventanaEditar.getAnioCumple());
		cal.set(Calendar.MONTH, this.ventanaEditar.getMesCumple()-1);
		cal.set(Calendar.DATE, this.ventanaEditar.getDiaCumple());
		Date cumpleanios = new Date(cal.getTimeInMillis());
		System.out.println("editarpersona ventanaeditar.getdiacumple" + this.ventanaEditar.getDiaCumple());
		System.out.println("calendario ventanaeditar " + cumpleanios);
		String etiqueta = this.ventanaEditar.getComboEtiqueta();
		String destino = this.ventanaEditar.getComboDestino();
		PersonaDTO nuevaPersona = new PersonaDTO(personaId, domicilioId, nombre, tel, email, cumpleanios, etiqueta, destino);
		
		this.agenda.borrarPersona(personas.get(filaSeleccionadaAEditar));
		this.agenda.agregarPersona(nuevaPersona);
		this.refrescarTabla();
		this.ventanaEditar.cerrar();
	}

	private void mostrarReporte(ActionEvent r) {
		ReporteAgenda reporte = new ReporteAgenda();
		reporte.mostrar();
	}

	public void borrarPersona(ActionEvent s) {
		int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		for (int fila : filasSeleccionadas) {
			this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			this.agenda.borrarDomicilio(this.domiciliosEnTabla.get(fila));
		}

		this.refrescarTabla();
	}

	public void inicializar() {
		this.refrescarTabla();
		this.vista.show();
	}

	private void refrescarTabla() {
		this.personasEnTabla = agenda.obtenerPersonas();
		this.domiciliosEnTabla = agenda.obtenerDomicilios();
		this.vista.llenarTabla(this.personasEnTabla, this.domiciliosEnTabla);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//
	}

}
