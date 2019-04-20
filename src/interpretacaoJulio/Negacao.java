package interpretacaoJulio;

public class Negacao implements ExpressaoBooleana {
	
	private Boolean associatedValue;
	
	Negacao(Boolean associatedValue) {
		this.associatedValue = associatedValue;
	}
	
	@Override
	public Boolean computa() {
		return !associatedValue;
	}
	
	@Override
	public String toString() {
		return "!" + associatedValue.toString();
	}
}
