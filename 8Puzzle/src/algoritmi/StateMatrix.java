package algoritmi;

import model.Matrix;
import model.Stare;

/**
 * Aceasta clasa este folosita in implementarea algoritmului A* intrucat introduce in notiunea de stare nivelul, pe langa continutul efectiv 
 * al matricii
 * @author Emilian
 *
 */
public class StateMatrix extends Stare implements Comparable<StateMatrix>{
	
	protected int level;
	protected Matrix stateMatrix;
	
	public StateMatrix(int p,Matrix m) {
		this.level=p;
		this.stateMatrix=m;
	}
	
	

	public int getPriority() {
		return level;
	}



	public void setPriority(int priority) {
		this.level = priority;
	}



	public Matrix getStateMatrix() {
		return stateMatrix;
	}



	public void setStateMatrix(Matrix stateMatrix) {
		this.stateMatrix = stateMatrix;
	}

	


	@Override
	public String toString() {
		return "StateMatrix [priority=" + level + ", stateMatrix=" + stateMatrix + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateMatrix other = (StateMatrix) obj;
		if (level != other.level)
			return false;
		if (stateMatrix == null) {
			if (other.stateMatrix != null)
				return false;
		} else if (!stateMatrix.equals(other.stateMatrix))
			return false;
		return true;
	}



	@Override
	public int compareTo(StateMatrix o) {
		if(this.level>o.getPriority())
			return 1;
		else 
			if(this.level<o.getPriority())
				return -1;
			else 
				return 0;
	}

}
