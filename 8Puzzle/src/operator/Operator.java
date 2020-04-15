package operator;

import model.Matrix;
import model.Pozitie;

/**
 * 
 * @author Emilian
 *
 */

public abstract class Operator {
	
	public boolean skip=false;
	
	public abstract boolean valabil(Matrix m);
	public abstract Matrix execute(Matrix m);
	
	public Pozitie determinarePozitieZero(Matrix m) {
			return m.pozitieZero();
	}
}
