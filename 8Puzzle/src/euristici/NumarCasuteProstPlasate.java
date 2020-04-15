package euristici;

import model.Matrix;
import model.Pozitie;

public class NumarCasuteProstPlasate extends Euristica {

	public NumarCasuteProstPlasate(){
		
	}
	
	public NumarCasuteProstPlasate(Matrix m){
		super(m);
	}
	
	@Override
	public int evaluate(Matrix m) {
		int rezultat=0;
		for(int i=1;i<=8;i++) {
			Pozitie pi=m.getPozitie(i);
			Pozitie pf=this.stareFinala.getPozitie(i);
			if(!pi.equals(pf))
				rezultat=rezultat+1;
		}
		return rezultat;
	}
	
	/*
	public static void main(String ...strings) {
		Matrix m=new Matrix();
		System.out.println(m);
		Manhattan euristica=new Manhattan(Matrix.solutie);
		NumarCasuteProstPlasate euristica2=new NumarCasuteProstPlasate(Matrix.solutie);
		Pozitie p=m.getPozitie(1);
		System.out.println(euristica.numarMutari(1,p));
		System.out.println("Euristica Manhatan: "+euristica.evaluate(m));
		System.out.println("Euristica Numar Casute Prost Plasate: "+euristica2.evaluate(m));
	}*/

}
