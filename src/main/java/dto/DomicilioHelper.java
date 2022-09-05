package dto;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DomicilioHelper {

	private List<String> paises = new ArrayList<String>();
	private List<String> provincias = new ArrayList<String>();
	private List<String> localidades = new ArrayList<String>();

	public String[] getCountries() {
		try {
			JSONArray worldCities = (JSONArray) new JSONParser().parse(new FileReader("worldCities.json"));

			for (int i = 0; i < worldCities.size(); i++) {
				JSONObject childrenObject = (JSONObject) worldCities.get(i);
				String country = (String) childrenObject.get("country");

				if (!paises.contains(country)) {
					paises.add(country);
				}
			}
			paises.add(0, "Select an option");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String[] array = paises.toArray(new String[0]);
		return array;
	}
	
	public String[] getStatesOf(String countryParameter){
		provincias = new ArrayList<String>();
		try {
			JSONArray worldCities = (JSONArray) new JSONParser().parse(new FileReader("worldCities.json"));

			for (int i = 0; i < worldCities.size(); i++) {
				JSONObject childrenObject = (JSONObject) worldCities.get(i);
				String country = (String) childrenObject.get("country");
				String subcountry = (String) childrenObject.get("subcountry");
				
				if(country.equals(countryParameter) && !provincias.contains(subcountry)) {
					provincias.add(subcountry);
				}
			}
			provincias.add(0, "Select an option");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String[] array = provincias.toArray(new String[0]);
		return array;
	}
	
	public String[] getCitiesOf(String countryParameter, String subcountryParameter){
		localidades = new ArrayList<String>();
		try {
			JSONArray worldCities = (JSONArray) new JSONParser().parse(new FileReader("worldCities.json"));

			for (int i = 0; i < worldCities.size(); i++) {
				JSONObject childrenObject = (JSONObject) worldCities.get(i);
				String country = (String) childrenObject.get("country");
				String subcountry = (String) childrenObject.get("subcountry");
				String city = (String) childrenObject.get("name");
				
				if(country.equals(countryParameter) && subcountry.equals(subcountryParameter) && !localidades.contains(city)) {
					localidades.add(city);
				}
			}
			localidades.add(0, "Select an option");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String[] array = localidades.toArray(new String[0]);
		return array;
	}
	
}
