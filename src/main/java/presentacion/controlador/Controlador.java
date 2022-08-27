package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.DomicilioDTO;
import dto.PersonaDTO;

public class Controlador implements ActionListener {
	private Vista vista;
	private List<PersonaDTO> personasEnTabla;
	private List<DomicilioDTO> domiciliosEnTabla;
	private VentanaPersona ventanaPersona;
	private Agenda agenda;

	public Controlador(Vista vista, Agenda agenda) {
		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(a -> ventanaAgregarPersona(a));
		this.vista.getBtnBorrar().addActionListener(s -> borrarPersona(s));
		this.vista.getBtnReporte().addActionListener(r -> mostrarReporte(r));
		this.ventanaPersona = VentanaPersona.getInstance();
		this.ventanaPersona.getBtnAgregarPersona().addActionListener(p -> guardarPersona(p));
		this.agenda = agenda;
	}

	private void ventanaAgregarPersona(ActionEvent a) {
		this.ventanaPersona.mostrarVentana();
	}

	private void guardarPersona(ActionEvent p) {

		String calle = this.ventanaPersona.getTxtCalle().getText();
		int altura = ((int) this.ventanaPersona.getSpinAltura().getValue());
		int piso = ((int) this.ventanaPersona.getSpinPiso().getValue());
		String depto = this.ventanaPersona.getTxtDepto().getText();
		String provincia = this.ventanaPersona.getComboProv().getSelectedItem().toString();
		String localidad = this.ventanaPersona.getComboLocal().getSelectedItem().toString();
		DomicilioDTO nuevoDomicilio = new DomicilioDTO(0, 0, calle, altura, piso, depto, provincia, localidad);

		String nombre = this.ventanaPersona.getTxtNombre().getText();
		String tel = this.ventanaPersona.getTxtTelefono().getText();
		String email = this.ventanaPersona.getTxtEmail().getText();
		PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email);

		this.agenda.agregarPersona(nuevaPersona);
		this.agenda.agregarDomicilio(nuevoDomicilio);
		this.refrescarTabla();
		this.ventanaPersona.cerrar();
	}

	private void mostrarReporte(ActionEvent r) {
		ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
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
		this.vista.llenarTabla(this.personasEnTabla);
		// prueba elias
		//System.out.println(personasEnTabla.get(0).getNombre());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
