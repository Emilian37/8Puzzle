package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

import exceptii.InvalidMatrix;

/**
 * 
 * @author Emilian
 *
 */

public class Matrix extends Stare{
	public static final int N=5;
	protected int matrix[][]=new int[N][N];
	
	public static Matrix solutie;
	
	static {
		try {
			solutie=new Matrix(1,2,3,4,5,6,7,8,0);
		} catch (InvalidMatrix e) {
			e.printStackTrace();
		}
	}
	
	public static Logger loger=Logger.getAnonymousLogger();
	/**
	 * Constructor care genereaza aleator matricea 
	 */
	public Matrix() {
		Random r=new Random();
		creareContur();
		ArrayList<Pozitie> pozitii=new ArrayList<Pozitie>();
		for(int nr=1;nr<=8;nr++) {
			Pozitie p=null;
			do {
				int i=1+r.nextInt(3);
				int j=1+r.nextInt(3);
				p=new Pozitie(i,j);
			}while(pozitii.contains(p));
			pozitii.add(p);
			matrix[p.getI()][p.getJ()]=nr;
			//loger.info(" Nr"+nr+" ("+p.getI()+","+p.getJ()+")");
		}
	}
	
	/**
	 * 
	 * @param el
	 */
	public Matrix(int ...el) throws InvalidMatrix{
		creareContur();
		int k[]= {0,0,0,0,0,0,0,0,0};
		for(int i:el)
			k[i]++;
		boolean valid=true;
		for(int contor:k)
			valid=valid&&(contor==1);
		if(valid==false) {
			InvalidMatrix e=new InvalidMatrix();
			throw e;
		}
		matrix[1][1]=el[0];
		matrix[1][2]=el[1];
		matrix[1][3]=el[2];
		matrix[2][1]=el[3];
		matrix[2][2]=el[4];
		matrix[2][3]=el[5];
		matrix[3][1]=el[6];
		matrix[3][2]=el[7];
		matrix[3][3]=el[8];
	}
	
	/**
	 * Functia creaza conturul matricii, punand -1 pe contur 
	 */
	public void creareContur() {
		// populare prima linie 
		for(int i=0;i<N;i++)
			matrix[0][i]=-1;
		// populare ultima linie
		for(int i=0;i<N;i++)
			matrix[N-1][i]=-1;
		// populare prima coloana 
		for(int j=0;j<N;j++)
			matrix[j][0]=-1;
		// populare ultima coloana
		for(int j=0;j<N;j++)
			matrix[j][N-1]=-1;
	}
	
	public int getElement(Pozitie p) {
		return this.matrix[p.getI()][p.getJ()];
	}
	
	public void setElement(Pozitie p, int val) {
		this.matrix[p.getI()][p.getJ()]=val;
	}
	
	public String toString() {
		String s="";
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				s=s+String.format(" %3d ",matrix[i][j]);
			s=s+"\n";
		}
		return s;
		
	}
	
	public Pozitie pozitieZero() {
		Pozitie p=null;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(matrix[i][j]==0) {
					return new Pozitie(i,j);
				}
		return p;
	}
	
	public Matrix clonare() {
		Matrix m=null;
		try {
			m = new Matrix(matrix[1][1],matrix[1][2],matrix[1][3],matrix[2][1],matrix[2][2],matrix[2][3],matrix[3][1],matrix[3][2],matrix[3][3]);
		} catch (InvalidMatrix e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Matrix interschimbare(Pozitie a,Pozitie b) {
		Matrix clona=this.clonare();
		int aux=clona.getElement(a);
		clona.setElement(a, clona.getElement(b));
		clona.setElement(b, aux);
		return clona;
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		boolean raspuns=true;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(this.matrix[i][j]!=other.getElement(new Pozitie(i,j)))
				{
					raspuns=false;
					break;
				}
		return raspuns;
	}
	
	/**
	 * Functia determina pozitia pe care se gaseste un numar 
	 * @param nr Numarul cautat trebuie sa fie in intervalul 1-8
	 * @return pozitie pe care se gaseste numarul in matrice 
	 */
	public Pozitie getPozitie(int nr) {
		Pozitie p=null;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(matrix[i][j]==nr) {
					return new Pozitie(i,j);
				}
		return p;
	}
	
	
}
