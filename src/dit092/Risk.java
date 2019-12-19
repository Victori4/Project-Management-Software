package dit092;

public class Risk {
	
	private String riskName;
	private double impact;
	private double probability;
	
	public Risk(String riskName, double impact, double probability) {
		this.riskName = riskName;
		this.impact = impact;
		this.probability = probability;
	}
	
	public double calculateRisk() {
		double risk;
		risk = this.impact * this.probability;
		return risk;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public double getImpact() {
		return impact;
	}

	public void setImpact(double impact) {
		this.impact = impact;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
}
