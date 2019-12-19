package dit092;

/**
 * Represents a risk in a project. Has a name, impact, probability and a calculated risk-value.
 */
public class Risk {
	private String ID;
	private String riskName;
	private double impact;
	private double probability;
	
	/**
	 * Creates an empty, default risk
	 */
	public Risk() {
		this.setID("");
		this.setRiskName("");
		this.setImpact(0.0);
		this.setProbability(0.0);
	}
	
	/**
	 * Creates a risk with a name, impact and probability
	 * 
	 * @param riskName the name of the risk
	 * @param impact the impact of the risk
	 * @param probability the probability of the risk
	 */
	public Risk(String ID, String riskName, double impact, double probability) {
		this.setID(ID);
		this.setRiskName(riskName);
		this.setImpact(impact);
		this.setProbability(probability);
	}
	
	/**
	 * Calculates the risk-value based on the impact and probability
	 * 
	 * @return this risks calculated risk-value
	 */
	public double calculateRisk() {
		double risk;
		risk = this.getImpact()* this.getProbability();
		return risk;
	}
	
	/**
	 * @return the ID of the risk
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param ID the ID of the risk
	 */
	public void setID(String ID) {
		this.ID = ID;
	}

	/**
	 * @return the name of the risk
	 */
	public String getRiskName() {
		return riskName;
	}

	/**
	 * @param riskName
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	/**
	 * @return the impact of the risk
	 */
	public double getImpact() {
		return impact;
	}

	/**
	 * @param impact
	 */
	public void setImpact(double impact) {
		this.impact = impact;
	}

	/**
	 * @return the probability of the risk
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * @param probability
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	//TODO Risk toString()	
	/**
	 *
	 */
	@Override
	public String toString() {
		return "Risk [calculateRisk()=" + calculateRisk() + ", getRiskName()=" + getRiskName() + ", getImpact()="
				+ getImpact() + ", getProbability()=" + getProbability() + "]";
	}
}
