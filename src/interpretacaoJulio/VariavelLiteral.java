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
		return environment.getLiteral(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
