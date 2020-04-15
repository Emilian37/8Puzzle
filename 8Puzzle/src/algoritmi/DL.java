package algoritmi;

import java.util.Stack;

import operator.*;
import model.*;

/**
 * Clasa realizeaza implementarea algoritmului de cautare in adancime limitata
 * @author Emilian
 *
 */

public class DL extends SolvingStrategy {
	
	/** noSol este o variabila booleana auxiliara care precizeaza daca s-a atins limita si nu s-a gasit o solutie*/
	boolean noSol=false;
	
	
	/** Metoda expand expandeaza nodul curent
	 * @param Matrice starea curenta a matricii
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
	

	@Override
	public void solving(Matrix m) {
		solving2(m,0,5);
		
	}
	/**
	 * Metoda solving2 care ne rezolva algoritmul de cautare in adancime limitata
	 * @param matrice 
	 */
	public synchronized void solving2(Matrix m, int currentDepth, int limit ){
		 /** Expandez un nou nod */	
		  Matrix s=expand(m);
		  /** Daca nodul expandat nu se mai gaseste in stiva starilor atunci */
		  if(!search(s)) {  
			  /** Adaug noul nod in stiva */
			  btStack.push(s);
			  /** Verific daca noul nod adaugat in stiva este solutie */
			  if(isSolution(s) )
				  return;
			  /** daca noul nod nu este solutie atunci continui cautarea */
			  else if( currentDepth >= limit )
					  noSol=true;
			  else {
				  for(int i=0;i<op.length;i++)
					  op[i].skip=false;
				  solving2(s, currentDepth+1, limit);
			      }		
		  } 
		  else /** in caz ca nodul expandat este deja in stiva */
			  if(btStack.size()!=0){
				  Matrix c=(Matrix)btStack.elementAt(btStack.size()-1);
				  solving2(c,currentDepth+1, limit);
			  }  
		}


}

