package interpretacaoJulio.Operacoes.OperacoesBooleanas;

import interpretacaoJulio.Interfaces.ExpressaoBooleana;

public class Negacao implements ExpressaoBooleana {
	
	private ExpressaoBooleana associatedValue;
	
	public Negacao(ExpressaoBooleana associatedValue) {
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
