package euristici;

import model.Matrix;

public abstract class Euristica {
	
	protected Matrix stareFinala;
	
	public Euristica() {
		
	}
	
	public Euristica(Matrix m) {
		this.stareFinala=m;
	}
	
	
	
	public Matrix getStareFinala() {
		return stareFinala;
	}



	public void setStareFinala(Matrix stareFinala) {
		this.stareFinala = stareFinala;
	}



	public abstract int evaluate(Matrix m);

}
