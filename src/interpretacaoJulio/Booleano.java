package interpretacaoJulio;

public class Booleano implements ExpressaoBooleana {
	
	private Boolean associatedValue;
	
	Booleano(Boolean value) {
		this.associatedValue = value;
	}
	
	@Override
	public Boolean computa() {
		System.out.println("Avaliei o booleano " + this.associatedValue);
		return this.associatedValue;
	}
	
	@Override
	public String toString() {
		return associatedValue.toString();
	}
}
