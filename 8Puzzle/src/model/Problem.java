package model;

import algoritmi.SolvingStrategy;

public class Problem {
	
	protected  Matrix stareInitiala;
	protected Matrix stareFinala;
	protected SolvingStrategy algoritm;
	
	private static Problem instance=null;
	
	public SolvingStrategy getAlgoritm() {
		return algoritm;
	}

	public void setAlgoritm(SolvingStrategy algoritm) {
		this.algoritm = algoritm;
	}

	
	private Problem() {
		
	}
	
	public static Problem getInstance() {
		if(instance==null)
			instance=new Problem();
		return instance;
	}

	public Matrix getStareInitiala() {
		return stareInitiala;
	}

	public void setStareInitiala(Matrix stareInitiala) {
		this.stareInitiala = stareInitiala;
		Matrix.loger.info("Setare matrice initiala: "+stareInitiala.toString());
	}

	public Matrix getStareFinala() {
		return stareFinala;
	}

	public void setStareFinala(Matrix stareFinala) {
		this.stareFinala = stareFinala;
		Matrix.loger.info("Setare matrice finaala: "+stareFinala.toString());
	}
	
	public void rezolvare() {
		this.getAlgoritm().setStareInitiala(this.stareInitiala);
		this.getAlgoritm().setStareFinala(this.stareFinala);
		this.algoritm.init();
		//this.algoritm.solving(this.stareInitiala);
		this.algoritm.rezolvare();
		this.algoritm.print();
	}
	
	
}
