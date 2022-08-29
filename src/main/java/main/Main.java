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
	
	/*
	ToDo:
	- Agregar las diferentes columnas al ReporteAgenda. Esto se hace modificando reportes/ReporteAgenda.jrxml (ver lo que mandaron por telegram)
	- Agregar cumpleaños a persona, lo manejamos como Date? Tiene Date MYSQL? O hacemos Date, pasarlo a string para guardarlo en mysql?
	- EDITAR CONTACTO
	
	- Que hace falta para entrega 3? Fijarse y agregarlo
	- Hacer documentación de todo y entregar
	*/
}
