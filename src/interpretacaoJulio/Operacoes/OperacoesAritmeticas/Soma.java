package interpretacaoJulio.Operacoes.OperacoesAritmeticas;

import interpretacaoJulio.Interfaces.ExpressaoAritmetica;

public class Soma implements ExpressaoAritmetica {
	
	private ExpressaoAritmetica expr1;
	private ExpressaoAritmetica expr2;

	public Soma(ExpressaoAritmetica expr1, ExpressaoAritmetica expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public Integer computa() {
		System.out.println("Avaliando Soma " + toString());
		Integer result = expr1.computa() + expr2.computa();
		System.out.println("Resultado da Soma " + toString() + " em " + result);
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + expr1.toString() + " + " + expr2.toString() + ")";
	}
	
}
