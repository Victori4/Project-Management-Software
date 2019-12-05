package dit092;

public class RiskMatrix {

	private double impact;
	private double probability;
	private double risk;
	private String riskName;
	
	public RiskMatrix (double impact, double probability, double risk, String riskName) {
		this.impact = impact;
		this.probability = probability;
		this.risk = risk;
		this.riskName = riskName;
	}
	
	public double calculateRisk() {
		risk = impact * probability;
		return risk;
	}
	
	public double getImpact() {
		return impact;
	}
	
	public double getProbability() {
		return probability;
	}
	
	public double getRisk() {
		return risk;
	}
	
	public String getRiskName() {
		return riskName;
	}
	
	public void setImpact(double impact) {
		this.impact = impact;
	}
	
	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	public void setRisk(double risk) {
		this.risk = risk;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
}
