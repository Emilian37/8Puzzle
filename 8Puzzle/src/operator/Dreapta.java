package operator;

import model.Matrix;
import model.Pozitie;


/**
 * 
 * @author Emilian
 *
 */
public class Dreapta extends Operator{

	@Override
	public boolean valabil(Matrix m) {
		Pozitie p0=m.pozitieZero();
		if(p0!=null) {
			Pozitie p1=new Pozitie(p0.getI(),p0.getJ()+1);
			if(p1.getI()!=-1 && p1.getJ()!=-1) {
				int el=m.getElement(p1);
				return el!=-1;
			}
			else 
				return false;
		}
		else return false;
	}

	@Override
	public Matrix execute(Matrix m) {
		if(valabil(m)) {
			Pozitie p0=m.pozitieZero();
			Pozitie p1=new Pozitie(p0.getI(),p0.getJ()+1);
			Matrix newMatrix=m.interschimbare(p0, p1);
			Matrix.loger.info("DREAPTA init:\n"+m.toString()+" final:\n"+newMatrix.toString());
			return newMatrix;
		}
		else 
			return m.clonare();
	}
	
}
