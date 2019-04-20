package interpretacaoJulio;

public class VariavelLiteral implements Variavel, ExpressaoAritmetica {
	
	public String associatedValue;
	private Ambiente environment;
	
	VariavelLiteral(String associatedValue, Ambiente environment) {
		this.associatedValue = associatedValue;
		this.environment = environment;
	}
	
	@Override
	public Integer computa() {
		System.out.println("Avaliando variável literal ");
		Integer result = environment.getLiteral(this);
		System.out.println("Avaliando variável literal no valor " + result);
		return result;
	}
	
	@Override
	public String toString() {
		return associatedValue;
	}
}
