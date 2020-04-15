package euristici;

import model.Matrix;
import model.Orientare;
import model.Pozitie;
/**
 * Clasa implementeaza euristica Manhattan, care calculeaza 
 * @author Emilian
 */

public class Manhattan extends Euristica {

	
	public Manhattan(Matrix m) {
		super(m);
	}
	
	/**
	 * Functia determina numarul de mutari pe care trebuie sa il faca un nr aflat pe pozitia P pana la locul lui.
	 * @param nr la care i se determina numarul de mutari 
	 * @param p pozitia in care se gaseste numarul 
	 * @return
	 */
	public int numarMutari(int nr,Pozitie pInitiala) {
		int nrMutari=0;
		// determin unde se afla nr in matricea solutie 
		Pozitie pFinal=Matrix.solutie.getPozitie(nr);
		if(pInitiala.equals(pFinal))
			return 0;
		if(pInitiala.diametralOpuse(pFinal))
			return 4;
		else {
			int contur=pInitiala.determinareContur(pFinal);
			Orientare orientare = pInitiala.orientare(pFinal);
			Matrix.loger.info(" Nr="+nr +" pinit="+pInitiala+" pFinal="+pFinal+" contur:"+contur+" orientare: "+orientare);
			if(contur==1) {
				if(orientare==Orientare.Nord || orientare==Orientare.Est || orientare==Orientare.Sud || orientare==Orientare.Vest)
					return 1;
				else 
					if(orientare==Orientare.NordEst || orientare==Orientare.NordVest || orientare==Orientare.SudEst || orientare==Orientare.SudVest)
						return 2;
			}
			else if(contur==2) {
				if(orientare==Orientare.Nord || orientare==Orientare.Est || orientare==Orientare.Sud || orientare==Orientare.Vest)
					return 2;
				else 
					if(orientare==Orientare.NordEst || orientare==Orientare.NordVest || orientare==Orientare.SudEst || orientare==Orientare.SudVest)
						return 3;
			}
		}
		return nrMutari;
	}
	
	@Override
	public int evaluate(Matrix m) {
		int rezultat=0;
		for(int i=1;i<=8;i++) {
			Pozitie p=m.getPozitie(i);
			int k=numarMutari(i,p);
			Matrix.loger.info(" Numar "+i+" Mutari: "+k);
			rezultat=rezultat+k;
		}
		return rezultat;
	}
	


}
