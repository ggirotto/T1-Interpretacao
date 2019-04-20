package interpretacaoJulio.Variaveis;

import interpretacaoJulio.Ambiente;
import interpretacaoJulio.Interfaces.ExpressaoBooleana;
import interpretacaoJulio.Interfaces.Variavel;

public class VariavelBoleana implements Variavel, ExpressaoBooleana {
	
	public String associatedValue;
	private Ambiente environment;
	
	public VariavelBoleana(String associatedValue, Ambiente environment) {
		this.associatedValue = associatedValue;
		this.environment = environment;
	}
	
	@Override
	public Boolean computa() {
		System.out.println("Avaliando variável booleana " + this.associatedValue);
		Boolean result = environment.getBooleano(this);
		System.out.println("Avaliando variável booleana " + this.associatedValue + " no valor " + result);
		return result;
	}
	
	@Override
	public String toString() {
		return associatedValue;
	}
}
