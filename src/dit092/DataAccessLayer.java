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
	
	public Project loadProject() {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(filepath)) {
			Object jsonObject = jsonParser.parse(reader);
			JSONObject parser = (JSONObject) jsonObject;
			Team team = loadTeam(parser);

			return new Project(team);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private Team loadTeam(JSONObject obj) {
		Long teamId = (Long) obj.get("id");
		JSONArray members = (JSONArray) obj.get("members");
		ArrayList<TeamMember> membersList = loadMembers(members);
		Team team = new Team(Math.toIntExact(teamId), membersList);
		return team;
	}

	private ArrayList<TeamMember> loadMembers(JSONArray arr) {
		ArrayList<TeamMember> members = new ArrayList<TeamMember>();

		for (Object mem : arr) {
			JSONObject member = (JSONObject) mem;

			String name = (String) member.get("name");
			Long id = (Long) member.get("id");
			JSONArray tasksArr = (JSONArray) member.get("tasks");
			ArrayList<Task> tasks = loadTasks(tasksArr);

			members.add(new TeamMember(Math.toIntExact(id), name, tasks));
		}

		return members;
	}

	private ArrayList<Task> loadTasks(JSONArray arr) {
		ArrayList<Task> tasks = new ArrayList<Task>();

		for (Object task : arr) {
			JSONObject taskObj = (JSONObject) task;
			String id = (String) taskObj.get("id");
			String name = (String) taskObj.get("taskName");
			Long plannedStartWeek = (Long) taskObj.get("plannedStartWeek");
			Long actualStartWeek = (Long) taskObj.get("actualStartWeek");
			Long plannedEndWeek = (Long) taskObj.get("plannedEndWeek");
			Long actualEndWeek = (Long) taskObj.get("plannedEndWeek");
			double estimatedHours = (Double) taskObj.get("estimatedHours");
			double actualHours = (Double) taskObj.get("actualHours");

			tasks.add(new Task(id, name, Math.toIntExact(plannedStartWeek), Math.toIntExact(actualStartWeek),
					Math.toIntExact(plannedEndWeek), Math.toIntExact(actualEndWeek), estimatedHours,
					actualHours));
		}

		return tasks;
	}

}
