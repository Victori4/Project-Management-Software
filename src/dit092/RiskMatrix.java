package dit092;

import java.util.ArrayList;

/**
 * A collection of risks represented as a risk matrix
 */
public class RiskMatrix {
	ArrayList<Risk> risks;
	
	/**
	 * Creates an empty, default risk matrix
	 */
	public RiskMatrix() {
		risks = new ArrayList<Risk>();
	}

	/**
	 * Creates a risk matrix with one risk
	 * @param risk
	 */
	public RiskMatrix(Risk risk) {
		risks = new ArrayList<Risk>();
		addRisk(risk);
	}

	/**
	 * Creates a risk matrix with a list of risks
	 * @param risks
	 */
	public RiskMatrix(ArrayList<Risk> risks) {
		this.risks = new ArrayList<Risk>();
		addRisks(risks);
	}
	
	/**
	 * Adds a risk to the risk matrix
	 * @param risk the risk to be added
	 */
	public void addRisk(Risk risk) {
		risks.add(risk);
	}
	
	/**
	 * Adds a list of risks to the risk matrix
	 * @param risks the list of risks to be added
	 */
	public void addRisks(ArrayList<Risk> risks) {
		this.risks.addAll(risks);
	}

	//TODO RiskMatrix toString()
	@Override
	public String toString() {
		String string  = "";
		
		//Labels
		string = string + "ID:     Name:     Impact:     Probability:     Risk: " + "\n";
		
		//Lines of risks
		for(Risk risk : risks) {
			string = string + risk.toString() + "\n";
		}
		
		return string;
	}
}
