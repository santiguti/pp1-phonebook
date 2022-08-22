package dto;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DomicilioHelper {

	private List<String> localidades;
	private List<String> provincias;

	public void parseLocalidades() {
		try {
			Object localidad = new JSONParser().parse(new FileReader("exlibraries/localidades.json"));
			this.localidades = new ArrayList<String>();
			JSONObject jObject = (JSONObject) localidad;
			JSONArray jArray = (JSONArray) jObject.get("localidades");

			for (int i = 0; i < jArray.size(); i++) {
				JSONObject childrenObject = (JSONObject) jArray.get(i);
				this.localidades.add((String) childrenObject.get("nombre"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(localidades);
	}

	public void parseProvincias() {
		try {
			Object provincia = new JSONParser().parse(new FileReader("exlibraries/provincias.json"));
			this.provincias = new ArrayList<String>();
			JSONObject jObject = (JSONObject) provincia;
			JSONArray jArray = (JSONArray) jObject.get("provincias");

			for (int i = 0; i < jArray.size(); i++) {
				JSONObject childrenObject = (JSONObject) jArray.get(i);
				this.provincias.add((String) childrenObject.get("nombre"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(provincias);
	}

	public List<String> getLocalidades() {
		return this.localidades;
	}
	
	public  String[] getLocalidadesArray() {
		String[] array = localidades.toArray(new String[0]);
		return array;
	}

	public List<String> getProvincias() {
		return this.provincias;
	}
	
	public  String[] getProvinciasArray() {
		String[] array = provincias.toArray(new String[0]);
		return array;
	}

}
