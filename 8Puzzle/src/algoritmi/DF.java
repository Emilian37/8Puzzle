package algoritmi;

import model.Matrix;


/**
 * Clasa realizeaza implementarea algoritmului de cautare in adancime 
 * @author Emilian
 */
public class DF extends SolvingStrategy {
	
	/** Metoda expand expandeaza nodul curent
	 * @param Matricea starea curenta 
	 * @return temp nodul expandat*/
	public Matrix expand(Matrix m){
		Matrix temp=m.clonare();
		for(int i=0;i<op.length;i++){
			if(op[i].skip==false)
				if(op[i].valabil(m))
				{
					temp=op[i].execute(temp);
					op[i].skip=true;
					return temp;
				}			
		}
		return temp;			
	}

	/**
	 * Metoda solving care ne rezolva algoritmul de cautare in adancime 
	 * @param  starea matrice 
	 */
	@Override
	public synchronized void solving(Matrix m) {
		
		if(k<200)
			k++;
		else 
			return;

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

		

}
