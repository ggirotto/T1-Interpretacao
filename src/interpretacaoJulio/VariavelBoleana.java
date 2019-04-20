package interpretacaoJulio;

public class VariavelBoleana implements Variavel, ExpressaoBooleana {
	
	public String associatedValue;
	private Ambiente environment;
	
	VariavelBoleana(String associatedValue, Ambiente environment) {
		this.associatedValue = associatedValue;
		this.environment = environment;
	}
	
	@Override
	public Boolean computa() {
		System.out.println("Avaliando variável booleana ");
		Boolean result = environment.getBooleano(this);
		System.out.println("Avaliando variável booleana no valor " + result);
		return result;
	}
	
	@Override
	public String toString() {
		return associatedValue;
	}
}
