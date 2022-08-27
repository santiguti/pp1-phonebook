package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.itextpdf.text.log.SysoCounter;
import java.sql.*;

import modelo.Agenda;
import persistencia.conexion.Conexion;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.Domicilio;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			this.agenda = agenda;
		}
		
		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
		}

		private void guardarPersona(ActionEvent p) {
			/*Domicilio domicilio = new Domicilio();
			domicilio.setCalle(this.ventanaPersona.getTxtCalle().getText());
			domicilio.setAltura((int) this.ventanaPersona.getSpinAltura().getValue());
			domicilio.setPiso((int) this.ventanaPersona.getSpinPiso().getValue());
			domicilio.setDepto(this.ventanaPersona.getTxtDepto().getText());
			domicilio.setProvincia(this.ventanaPersona.getComboProv().getSelectedItem().toString());
			domicilio.setLocalidad(this.ventanaPersona.getComboLocal().getSelectedItem().toString());*/
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = this.ventanaPersona.getTxtTelefono().getText();
			String calle = this.ventanaPersona.getTxtCalle().getText();
			
			String numeroCalle = this.ventanaPersona.getTxtAltura().getText();
			String piso = this.ventanaPersona.getTxtPiso().getText();
			
			//agregar email, cumpleanios, etc
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, null, null, null, calle, numeroCalle, piso);
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}

		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}

		public void borrarPersona(ActionEvent s)
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}
			
			this.refrescarTabla();
		}
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonas();
			this.vista.llenarTabla(this.personasEnTabla);
			//prueba elias
			System.out.println(personasEnTabla.get(0).getNombre());
			
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
