package dit092;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.*;


public class DataAccessLayer {
private final String filepath = "././TEST.json";
	
	public DataAccessLayer () {
		
	}
	
	
	public Project loadProject() {
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(filepath)){
			Object jsonObject = jsonParser.parse(reader);
			JSONObject hello = (JSONObject) jsonObject;
			Project project = new Project((Team) hello.get("team"));
			return project;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
		e.printStackTrace();	
		} catch(ParseException e) {
		e.printStackTrace();	
		}  
		return null;
	
	}
	
	private ArrayList<Task> loadTasks(JSONObject object) {
		
	}

}
