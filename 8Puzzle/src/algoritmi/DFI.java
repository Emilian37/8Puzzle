package algoritmi;

import java.util.Stack;

import model.*;
import operator.*;

/**
 * Clasa realizeaza implementarea algoritmului de cautare iterativ
 * @author Emilian
 *
 */
public class DFI extends SolvingStrategy {
	
	/** Metoda expand expandeaza nodul curent
	 * @param Matrice starea curenta a matricii
	 * @return temp nodul expandat*/
	public Matrix expand(Matrix m){
		Matrix temp=m.clonare();
		for(int i=0;i<op.length;i++){
		    if(op[i].valabil(temp) && op[i].skip==false){
		    	temp=op[i].execute(temp);
		    	op[i].skip=true;
		    	return temp;
	        }			
		}
		return temp;			
	}
	
	
	/**Metoda search cauta starea s in stiva starilor
	 * @param s starea cautata
	 * @return r true daca starea se afla in stiva starilor
	 */
	public boolean search(Matrix m){
		boolean r=false;
		for(int i=0;i<btStack.size();i++)
			if(((Matrix)btStack.elementAt(i)).equals(m)){
				return true;	
			}
		return r;
	}

	/**
	 * Metoda solving care ne rezolva algoritmul de cautare iterativ 
	 * @param m starea matricii
	 */
	@Override
	public void solving(Matrix m) {
		solving2(m,9);
		
	}
	
	public synchronized void solving2(Matrix m, int depth)
	{
		for(int j=1; j <= depth; j++)
		{
			/** Expandez un nou nod */
			Matrix s=expand(m);
			  /** Daca nodul expandat nu se mai gaseste in stiva starilor atunci */
			if(!search(s)) {   
				 /** Adaug noul nod in stiva */
				btStack.push(s);
				 /** Verific daca noul nod adaugat in stiva este solutie sau daca adancimea este 0 */
				if(isSolution(s) || depth == 0  )
					return;
				else {/** daca conditia de mai sus nu este satisfacuta, continui cautarea */
				  for(int i=0;i<op.length;i++)
					  op[i].skip=false;
				  solving2(s,depth-1);
				  }
				/** in caz ca nodul expandat este deja in stiva */
				} else if(btStack.size()!=0){
					  Matrix c=(Matrix)btStack.elementAt(btStack.size()-1);
					  solving2(c,depth-1);
					  }
			}
	}

	
}

