package interpretacaoJulio.Operacoes.OperacoesBooleanas;

import interpretacaoJulio.Interfaces.ExpressaoBooleana;

public class Ou implements ExpressaoBooleana {
	
	private ExpressaoBooleana expr1;
	private ExpressaoBooleana expr2;

	public Ou(ExpressaoBooleana expr1, ExpressaoBooleana expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public Boolean computa() {
		System.out.println("Avaliando Ou Lógico " + toString());
		Boolean result = expr1.computa() || expr2.computa();
		System.out.println("Resultado do Ou Lógico " + toString() + " em " + result);
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + expr1.toString() + " || " + expr2.toString() + ")";
	}
	
}
