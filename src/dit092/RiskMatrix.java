package dit092;

import java.util.ArrayList;

public class RiskMatrix {
	ArrayList<Risk> risks;
	
	public RiskMatrix() {
		risks = new ArrayList<Risk>();
	}
	
	public RiskMatrix(Risk risk) {
		risks = new ArrayList<Risk>();
		risks.add(risk);
	}
	
	public RiskMatrix(ArrayList<Risk> risks) {
		risks = new ArrayList<Risk>();
		risks.addAll(risks);
	}
	
	public void addRisk(Risk risk) {
		risks.add(risk);
	}

	//TODO RiskMatrix toString()
	@Override
	public String toString() {
		return "RiskMatrix [risks=" + risks + "]";
	}
}
