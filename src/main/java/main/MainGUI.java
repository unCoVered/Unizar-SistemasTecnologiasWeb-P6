/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion:
 * Tiempo invertido:
 */
package main;

import GUI.MainWindow;
import parser.XML.ExtraerNombres;

import java.io.File;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Clase con el main de la aplicacion
 * Muestra una ventana que permite elegir municipio y tipo de fichero a obtener
 */
public class MainGUI
{

	private static String RUTA_RESOURCES = "/home/alex/Repositories/stw/Practica6/src/main/resources/predictions";

	public static void main(String[] args)
	{
		//Metodo para obtener la lista de municipios
//		System.out.println("Descargando XML de predicciones");
//		for(int i=50001; i<50299; i++)
//		{
//			GestorDescargaFichero.descargarFichero(RUTA_RESOURCES,
//					"http://www.aemet.es/xml/municipios/localidad_" + i +".xml");
//		}

		File directory = new File(RUTA_RESOURCES);
		SortedMap<Integer, String> localidades = new TreeMap<Integer, String>();
		if(directory.exists()){
			File[] directoryList = directory.listFiles();
			for(File file : directoryList)
			{
				String archivo = RUTA_RESOURCES+ "/" +file.getName();
				ExtraerNombres.rellenaMapLocalidades(archivo, localidades);
			}
		}
		else
			System.out.println("No existe el directorio!");

		//Muestra la ventana con los municipio
		MainWindow window = new MainWindow(localidades);
	}

}
