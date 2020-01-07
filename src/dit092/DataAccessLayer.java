package dit092;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.*;

public class DataAccessLayer {
	/**
	 * Change the filepath variable if you what to load a different JSON file.
	 */
	private final String filepath = "././Project_Data.json";

	/**
	 * Loads a project from a JSON file.
	 * A project consists of a team and a risk matrix.
	 * Returns null if no project could be loaded/created from JSON file.
	 * @return Project or null
	 */
	public Project loadProject() {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(filepath)) {
			Object jsonObject = jsonParser.parse(reader);
			JSONObject parser = (JSONObject) jsonObject;
			//Retrieves JSON for team
			JSONObject teamJSON = (JSONObject) parser.get("team");
			//Retrieves JSON for risk matrix
			JSONObject matrixJSON = (JSONObject) parser.get("riskMatrix");

			Team team = loadTeam(teamJSON);
			RiskMatrix matrix = loadRiskMatrix(matrixJSON);

			return new Project(team, matrix);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Creates a risk matrix object from JSONObject
	 * @param JSONObject obj
	 * @return RiskMatrix
	 */
	private RiskMatrix loadRiskMatrix(JSONObject obj) {
		JSONArray risksJSON = (JSONArray) obj.get("risks");
		ArrayList<Risk> risks = loadRisks(risksJSON);
		RiskMatrix matrix = new RiskMatrix(risks);
		return matrix;
	}

	/**
	 * Creates an ArrayList with Risks from JSONArray
	 * @param JSONArray arr
	 * @return ArrayList with risks
	 */
	private ArrayList<Risk> loadRisks(JSONArray arr) {
		ArrayList<Risk> risks = new ArrayList<Risk>();

		for (Object risk : arr) {
			JSONObject riskObj = (JSONObject) risk;

			String id = (String) riskObj.get("id");
			String riskName = (String) riskObj.get("riskName");
			double impact = (Double) riskObj.get("impact");
			double probability = (Double) riskObj.get("probability");

			risks.add(new Risk(id, riskName, impact, probability));
		}

		return risks;
	}

	/**
	 * Creates a team object from JSONObject
	 * @param JSONObject obj
	 * @return Team
	 */
	private Team loadTeam(JSONObject obj) {
		Long teamId = (Long) obj.get("id");
		JSONArray members = (JSONArray) obj.get("members");
		ArrayList<TeamMember> membersList = loadMembers(members);
		Team team = new Team(Math.toIntExact(teamId), membersList);
		return team;
	}

	/**
	 * Creates an ArrayList with TeamMembers for the Team
	 * @param JSONArray arr
	 * @return ArrayList with TeamMembers
	 */
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

	/**
	 * Creates an ArrayList of Tasks for a TeamMember
	 * @param JSONArray arr
	 * @return ArrayList with Tasks
	 */
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
