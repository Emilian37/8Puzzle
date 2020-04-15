package algoritmi;



import java.util.Vector;

import exceptii.InvalidMatrix;
import model.*;

/**
 * Clasa realizeaza implementarea algoritmului de cautare in latime 
 * @author Emilian
 *
 */

public class BF extends SolvingStrategy{
	
	
	int opp; 
	
	
	/** Metoda expand expandeaza nodul curent
	 * @param Matricea stare curenta
	 * @return temp nodul expandat*/
	public Matrix expand(Matrix m){
		Matrix temp=m.clonare();
		for(int i=0;i<op.length;i++){
		    if(op[i].valabil(temp) && op[i].skip==false) {
		    	temp=op[i].execute(temp);
		    	op[i].skip=true;
		    	return temp;
	        }			
		}
		return temp;			
	}
	
	public Vector<Matrix> expand2(Matrix m){
		Matrix temp=m.clonare();
		Vector<Matrix> matrici=new Vector<Matrix>();
		
		for(int i=0;i<op.length;i++)
			if(op[i].valabil(temp)&& op[i].skip==false)
			{
				matrici.add(op[i].execute(temp));
			}
		return matrici;	
	}
	
	/** Metoda langaSolutie este folosita pentru a spune daca din starea s 
	 * se poate ajunge prin aplicarea unui operator la starea scop
	 * @param s starea furnizata
	 * @return r true daca starea s este langa solutie */

	public boolean langaSolutie(Matrix s){
		boolean r=false;
		for(int i=0;i<op.length;i++)
			if(op[i].valabil(s))
				if(isSolution(op[i].execute(s))){
					 r=true;
					 opp=i;
				}
				 
		return r;
	}
	
	
	/**
	 * Metoda solving care ne rezolva algoritmul de cautare in latime 
	 * @param O matrice 
	 */
	@Override
	public synchronized void solving(Matrix m){
		/*if(k<100)
			k++;
		else 
			return;*/
		Matrix.loger.info("Rezolvare");
		/** obtin toate nodurile fiu ale nodului curent prin expandare */
		Vector<Matrix> matrici=expand2(m);
		/**	Verifcare daca nodurile expandate sunt "aproape" de solutie 
		 *  Daca se gaseste un nod anterior expandat "lnga solutie" atunci inchei procesul de cautare 
		 *  si introduc in stiva nodul expandat, si nodul de tip scop */
		for(int i=0;i<matrici.size();i++){
			 if(langaSolutie(matrici.elementAt(i))){
				 btStack.add(matrici.elementAt(i)); /**adaug nodul anterior expanadat in stiva solutiei */
				 Matrix c=op[opp].execute(matrici.elementAt(i)); /** obtin nodul scop */
				 btStack.add(c); /** adaug nodul scop in stiva solutiei */
				 return;
			 }
		   }		
		 Matrix s=expand(m);
		 /** Daca nodul expandat nu se mai gaseste in stiva starilor atunci */
		 if(!search(s)){   
			 /**Adaug noul nod in stiva */
			  btStack.push(s);
			  /** Verific daca noul nod adaugat in stiva este solutie */
			  if(isSolution(s))
				  return;
			  else {/**daca noul nod nu este solutie atunci continui cautarea */
				  for(int i=0;i<op.length;i++)
					  op[i].skip=false;
				  solving(s);
			      }
		  	} else if(btStack.size()!=0){ /**in caz ca nodul expandat este deja in stiva */
					  Matrix c=(Matrix)btStack.elementAt(btStack.size()-1);
					  solving(c);
					  }
	}
	
	
	
	/*public static void main(String strings[]) {
		Matrix m;
		try {
			m = new Matrix(0,1,3,4,2,5,7,8,6);
			BF bf=new BF();
			bf.setStareInitiala(m);
			bf.setStareFinala(new Matrix(1,2,3,4,5,6,7,8,0));
			bf.init();
			bf.solving(bf.stareInitiala);
			bf.print();
		} catch (InvalidMatrix e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

}
