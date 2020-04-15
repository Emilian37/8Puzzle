package exceptii;

@SuppressWarnings("serial")
public class InvalidMatrix extends Exception {
	
	@Override
	public String getMessage() {
		return "Matrice invalida !\nExista elemente duplicate";
	}
}
