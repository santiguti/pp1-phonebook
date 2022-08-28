package main;

import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;


public class Main 
{
	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo);
		controlador.inicializar();
	}
	
	// DEJE EN sql/scriptAgenda.sql el nuevo script para iniciar la base de datos
	
	/*
	ToDo:
	- Arreglar la Vista.java para mostrar domicilio O SINO eliminar domicilio de la vista y listo, mostramos solo nombre, telefono y email
	- Agregar las diferentes columnas al ReporteAgenda. Esto se hace modificando reportes/ReporteAgenda.jrxml
	- Hacer lo de JcomboBox para provincia, pais, localidad (esto no te preocupes yo lo hago)
	- Que hace falta para entrega 3? Fijarse y agregarlo
	- Agregar cumpleaños a persona, lo manejamos como Date? Tiene Date MYSQL? O hacemos Date, pasarlo a string para guardarlo en mysql?
	- Hacer documentación de todo y entregar
	*/
}
