package dit092;

public class RiskMatrix {

	private double impact;
	private double probability;
	public double risk;
	
	public RiskMatrix (double impact, double probability, double risk) {
		this.impact = impact;
		this.probability = probability;
		this.risk = risk;
	}
	
	public double calculateRisk() {
		risk = impact * probability;
		return risk;
	}
	
}
