package interpretacaoJulio;

public class Negacao implements ExpressaoBooleana {
	
	private ExpressaoBooleana associatedValue;
	
	Negacao(ExpressaoBooleana associatedValue) {
		this.associatedValue = associatedValue;
	}
	
	@Override
	public Boolean computa() {
		return !associatedValue.computa();
	}
	
	@Override
	public String toString() {
		return "!" + associatedValue.toString();
	}
}
