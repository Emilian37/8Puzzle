package algoritmi;

import java.util.Stack;

import model.Matrix;
import operator.Dreapta;
import operator.Jos;
import operator.Operator;
import operator.Stanga;
import operator.Sus;

/**
 * Clasa abstracta care trebuie sa fie mostenita de toate 
 * clasele care implementeaza algoritmii de cautare
 * @author Emilian
 */
public abstract class SolvingStrategy {
	
	protected Matrix stareInitiala;
	protected Matrix stareFinala;
	
	int k=0;
	
	/** btStack este stiva starilor*/
	Stack<Matrix> btStack=new Stack<Matrix>(); 
	
	/** op este vectorul cu operatii*/
	Operator op[]={new Sus(),new Jos(),new Stanga(),new Dreapta()};
	
	/** opp este indicele operatorului folosit pentru a obtine nodul scop*/
	
	public Matrix getStareInitiala() {
		return stareInitiala;
	}
	public void setStareInitiala(Matrix stareInitiala) {
		this.stareInitiala = stareInitiala;
	}
	
	
	public Matrix getStareFinala() {
		return stareFinala;
	}
	public void setStareFinala(Matrix stareFinala) {
		this.stareFinala = stareFinala;
	}
	
	/** Metoda init initializeaza stiva starilor cu starea initiala (0,0)*/
	public void init(){
		btStack.push(this.stareInitiala);
	}
	
	/**Metoda isSolution verifica daca starea s este solutie
	 *  @param s starea curenta
	 *  @return r true daca s este solutie
	 */
	public boolean isSolution(Matrix s){
		return s.equals(stareFinala);
	}
	
	public abstract void solving(Matrix c);
	
	/** Metoda print afiseaza matricile pana la solutie si realizeaza desenarea grafica a acestora la fiecare pas */
	public void print(){
		for(Matrix m:this.btStack)
			System.out.println(m);
	}
	
	/**Metoda search cauta starea s in stiva starilor
	 * @param s starea cautata
	 * @return r true daca starea se afla in stiva starilor
	 */
	public boolean search(Matrix s){
		boolean r=false;
		for(int i=0;i<btStack.size();i++)
			if(((Matrix)btStack.elementAt(i)).equals(s))
			{
				return true;
				
			}
		return r;
	}
	public void rezolvare() {
		Matrix.loger.info("Rezolvare: ");
		Matrix.loger.info("Stare initiala:"+this.stareInitiala.toString());
		Matrix.loger.info("Stare finala:"+this.stareFinala.toString());
		solving(this.stareInitiala);
	}
}