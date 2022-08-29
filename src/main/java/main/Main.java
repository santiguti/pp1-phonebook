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
	- EDITAR CONTACTO
	- Hacer documentación de todo y entregar
	*/
}
