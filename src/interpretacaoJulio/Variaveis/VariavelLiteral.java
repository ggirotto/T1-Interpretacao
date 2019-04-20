package interpretacaoJulio.Variaveis;

import interpretacaoJulio.Ambiente;
import interpretacaoJulio.Interfaces.ExpressaoAritmetica;
import interpretacaoJulio.Interfaces.Variavel;

public class VariavelLiteral implements Variavel, ExpressaoAritmetica {
	
	public String associatedValue;
	private Ambiente environment;
	
	public VariavelLiteral(String associatedValue, Ambiente environment) {
		this.associatedValue = associatedValue;
		this.environment = environment;
	}
	
	@Override
	public Integer computa() {
		System.out.println("Avaliando variável literal " + this.associatedValue);
		Integer result = environment.getLiteral(this);
		System.out.println("Avaliada variável literal " + this.associatedValue + " no valor " + result);
		return result;
	}
	
	@Override
	public String toString() {
		return associatedValue;
	}
}
