package dit092;

//JUnit imports
//Right-click project in Eclipse and go to: Properties -> Java Build Path -> Libraries -> Add Library -> JUnit -> Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.*;
import java.util.ArrayList;

public class Tests {
	private static Project testProject;
	private static Team testTeam;	
	private static RiskMatrix testRiskMatrix;
	private static ArrayList <TeamMember> testMembers;
	private static ArrayList <Task> testTasks;
	
	//Set-up of data to be used in testing
	@BeforeAll
	public static void init() {

		//Set up tasks
		testTasks.add(new Task("1", "Test Task 1", 1, 1, 1, 1, 1.0, 1.0));
		testTasks.add(new Task("2", "Test Task 2", 2, 2, 3, 4, 10.0, 10.0));
		testTasks.add(new Task("3", "Test Task 3", 5, 5, 5, 5, 5.0, 10.0));
		testTasks.add(new Task("4", "Test Task 4", 3, 3, 4, 5, 2.0, 4.0));
		testTasks.add(new Task("5", "Test Task 5", 2, 2, 4, 2, 15.0, 5.0));
		
		//Set up members
		testMembers.add(new TeamMember(1, "Test Member 1", testTasks));

		//Set up team
		testTeam = new Team(1, testMembers);
		
		//Empty risk matrix, not tested, just used for constructor
		testRiskMatrix = new RiskMatrix();
		
		//Set up the project used for testing
		testProject = new Project(testTeam, testRiskMatrix);
	}
	
	//Utility method for rounding the calculations
	//Taken from https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	@Test
	public void testActualCostAtCompletion() {
		double expected = 7500.0;
		//TODO change actual cost to take week into account
		double actual = testProject.calculateActualCost(); //At week 5
		assertEquals(expected, actual, "Actual Cost of Project should be 7500 SEK.");
	}
	
	@Test
	public void testBudgetAtComplection() {
		double expected = 8250.0;
		double actual = testProject.calculateBudgetAtCompletion();
		assertEquals(expected, actual, "Budget should be 8250 SEK.");
	}
	
	//EV Test
	@Test
	public void testEarnedValue() {
		//Week 1 Test
		double expected = 250.0;
		double actual = testProject.calculateEarnedValue(1);
		assertEquals(expected, actual, "Earned Value at week 1 should be 250 SEK.");
		
		//Week 2 Test
		expected = 4000.0;
		actual = testProject.calculateEarnedValue(2);
		assertEquals(expected, actual, "Earned Value at week 2 should be 4000 SEK.");

		//Week 3 Test
		expected = 4000.0;
		actual = testProject.calculateEarnedValue(3);
		assertEquals(expected, actual, "Earned Value at week 3 should be 4000 SEK.");
		
		//Week 4 Test
	}
	
	
	//PV Test
	@Test
	public void testPlannedValue() {
		//Week 1 Test
		double expected = 250.0;
		double actual =	testProject.calculatePlannedValue(1);
		assertEquals(expected, actual, "Planned Value at week 1 should be 250 SEK.");
		
		//Week 2 Test
		expected = 250.0;
		actual = testProject.calculatePlannedValue(2);
		assertEquals(expected, actual, "Planned Value at week 2 should be 250 SEK.");
		
		//Week 3 Test
		expected = 2750.0;
		actual = testProject.calculatePlannedValue(3);
		assertEquals(expected, actual, "Planned Value at week 3 should be 2750 SEK.");
		
		//Week 4 Test
		
		
	}
	
	//AC Test
	@Test
	public void testActualCost() {
		//Week 1 Test
	}

	//CPI Test
	@Test 
	public void testCostPerformanceIndex() {
		//Week 1 Test
		double expected = 1.0;
		double actual = testProject.calculateCostPerformanceIndex(1);
		assertEquals(expected, actual, "The Cost Performance Index at week 1 should be 1.");
		
		//Week 2 Test
		expected = 2.67;
		actual = testProject.calculateCostPerformanceIndex(2);
		actual = round(actual, 2);
		assertEquals(expected, actual, "The Cost Performance Index at week 2 should be 2.6666...");
		
		//Week 3 Test
		expected = 2.67;
		actual = testProject.calculateCostPerformanceIndex(3);
		actual = round(actual, 2);
		assertEquals(expected, actual, "The Cost Performance Index at week 3 should be 2.6666...");
	}

	//CV Test
	@Test
	public void testCostVariance() {
		//Week 1 Test
		double expected = 0.0;
		double actual = testProject.calculateCostVariance(1);
		assertEquals(expected, actual, "The Cost Variance at week 1 should be 0 SEK.");
		
		//Week 2 Test
		expected = 2500.0;
		actual = testProject.calculateCostVariance(2);
		assertEquals(expected, actual, "The Cost Variance at week 2 should be 2500 SEK.");
		
		//Week 3 Test
		expected = 2500.0;
		actual = testProject.calculateCostVariance(3);
		assertEquals(expected, actual, "The Cost Variance at week 3 should be 2500 SEK.");
		
	}

	//SPI Test
	@Test
	public void testSchedulePerformanceIndex() {
		//Week 1 Test
		double expected = 1.0; 
		double actual = testProject.calculateSchedulePerformanceIndex(1);
		assertEquals(expected, actual, "The Schedule Performance Index at week 1 should be 1.");	
		
		//Week 2 Test
		expected = 16; 
		actual = testProject.calculateSchedulePerformanceIndex(2);
		assertEquals(expected, actual, "The Schedule Performance Index at week 2 should be 16.");	
		
		//Week 3 Test
		expected = 1.45; 
		actual = testProject.calculateSchedulePerformanceIndex(3);
		actual = round(actual, 2);
		assertEquals(expected, actual, "The Schedule Performance Index at week 3 should be 1.454545...");	
		
	}
	
	//SV Test
	@Test
	public void testScheduleVariance() {
		//Week 1 Test
		double expected = 0.0;
		double actual = testProject.calculateScheduleVariance(1);
		assertEquals(expected, actual, "The Schedule Variance at week 1 should be 0 SEK.");
		
		//Week 2 Test
		expected = 3750.0;
		actual = testProject.calculateScheduleVariance(2);
		assertEquals(expected, actual, "The Schedule Variance at week 2 should be 3750 SEK.");
		
		//Week 3 Test
		expected = 1250.0;
		actual = testProject.calculateScheduleVariance(3);
		assertEquals(expected, actual, "The Schedule Variance at week 3 should be 1250 SEK.");
	}
}
