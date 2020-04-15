package algoritmi;

import java.util.Vector;

import euristici.Euristica;
import euristici.NumarCasuteProstPlasate;
import exceptii.InvalidMatrix;
import model.Matrix;

public class Greedy extends SolvingStrategy{

	protected Euristica euristica;
	
	public Greedy(Matrix mi,Matrix mf,Euristica e) {
		this.stareInitiala=mi;
		this.stareFinala=mf;
		this.euristica=e;
		this.euristica.setStareFinala(mf);
	}
	
	public Matrix expand(Matrix m){
		Matrix temp=m.clonare();
		Vector<Matrix> matrici=new Vector<Matrix>();
		
		for(int i=0;i<op.length;i++)
			if(op[i].valabil(temp)&& op[i].skip==false)
			{
				matrici.add(op[i].execute(temp));
			}
		
		int vmin=100;
		int pmin=-1;
		for(int i=0;i<matrici.size();i++)
			if(this.euristica.evaluate(matrici.get(i))<vmin) {
				vmin=this.euristica.evaluate(matrici.get(i));
				pmin=i;
			}
		return matrici.get(pmin).clonare();
	}
	

	/**
	 * Metoda solving care ne rezolva algoritmul de cautare in adancime 
	 */
	@Override
	public synchronized void solving(Matrix m) {

		  /** Expandez un nou nod */	
		  Matrix s=expand(m);
		  /** Daca nodul expandat nu se mai gaseste in stiva starilor atunci */
		  if(!search(s))
		  {   /** Adaug noul nod in stiva */
			  btStack.push(s);
			  /** Verific daca noul nod adaugat in stiva este solutie */
			  if(isSolution(s)){
				  return;
			  }
			  else /** daca noul nod nu este solutie atunci continui cautarea */
			      {
				  for(int i=0;i<op.length;i++)
					  op[i].skip=false;
				  solving(s);
			      }  
		  }
		  else /** in caz ca nodul expandat este deja in stiva */
			  if(btStack.size()!=0){
				  Matrix c=(Matrix)btStack.elementAt(btStack.size()-1);
				  solving(c);
			  }  
		
	}
	
	public static void main(String args[]) {
		try {
			Matrix mi=new Matrix(0,1,3,4,2,5,7,8,6);
			Matrix mf=new Matrix(1,2,3,4,5,6,7,8,0);
			Euristica e=new NumarCasuteProstPlasate();
			Greedy a=new Greedy(mi,mf,e);
			a.init();
			a.solving(mi);
			a.print();
		} catch (InvalidMatrix e) {
			e.printStackTrace();
		}
	}


}
