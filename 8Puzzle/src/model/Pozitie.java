package model;

/**
 * 
 * @author Emilian
 *
 */

public class Pozitie{
	int i;
	int j;
	
	public Pozitie(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pozitie other = (Pozitie) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "Pozitie [i=" + i + ", j=" + j + "]";
	}
	
	
	/**
	 * Functia determina orientarea pozitiei p relativ la pozitia curenta
	 * @param p
	 * @return
	 */
	public Orientare orientare(Pozitie p) {
		Orientare o=null;
		
		if((p.getI()==this.i-1 || p.getI()==this.i-2) && p.getJ()==this.j )
		{
			o=Orientare.Nord;
			return o;
		}
		if((p.getI()==this.i+1 || p.getI()==this.i+2) && p.getJ()==this.j) {
			o=Orientare.Sud;
			return o;
		}
		if(p.getI()==this.i && (p.getJ()==this.j+1 || p.getJ()==this.j+2)) {
			o=Orientare.Est;
			return o;
		}
		if(p.getI()==this.i && (p.getJ()==this.j-1 || p.getJ()==this.j-2)) {
			o=Orientare.Vest;
			return o;
		}
		
		//
		if((p.getI()==this.i-1 || p.getI()==this.i-2) && (p.getJ()==this.j+1||p.getJ()==this.j+2)) {
			o=Orientare.NordEst;
			return o;
		}
		if((p.getI()==this.i-1 || p.getI()==this.i-2)&&  (p.getJ()==this.j-1||p.getJ()==this.j-2)){
			o=Orientare.NordVest;
			return o;
		}
		if((p.getI()==this.i+1 || p.getI()==this.i+2) && (p.getJ()==this.j+1||p.getJ()==this.j+2)){
			o=Orientare.SudEst;
			return o;
		}
		if((p.getI()==this.i+1 || p.getI()==this.i+2) &&  (p.getJ()==this.j-1||p.getJ()==this.j-2)){
			o=Orientare.SudVest;
			return o;
		}
		return o;
	}
	
	/**
	 * Functia determina pe ce contur se afla pozitia p fata de pozitia curenta. 
	 * Exista contur-1 si contur-2. 
	 * @param p
	 * @return
	 */
	public int determinareContur(Pozitie p) {
		int dx=Math.abs(this.getI()-p.getI());
		int dy=Math.abs(this.getJ()-p.getJ());
		
		return Math.max(dx, dy);
	}
	
	public boolean diametralOpuse(Pozitie p) {
		if (this.i==1 && this.j==1 && p.getI()==3 && p.getJ()==3)
			return true;
		else 
			if (this.i==3 && this.j==3 && p.getI()==1 && p.getJ()==1)
				return true;
			else 
				if (this.i==3 && this.j==1 && p.getI()==1 && p.getJ()==3)
					return true;
				else
					if (this.i==1 && this.j==3 && p.getI()==3 && p.getJ()==1)
						return true;
					else 
						return false;
	}


	
	

}
