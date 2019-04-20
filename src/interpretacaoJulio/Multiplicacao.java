package interpretacaoJulio;

public class Multiplicacao implements ExpressaoAritmetica {
	
	private ExpressaoAritmetica expr1;
	private ExpressaoAritmetica expr2;
	
	Multiplicacao(ExpressaoAritmetica expr1, ExpressaoAritmetica expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public Integer computa() {
		System.out.println("Avaliando Multiplicacao " + toString());
		Integer result = expr1.computa() * expr2.computa();
		System.out.println("Resultado da Multiplicacao " + toString() + " em " + result);
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + expr1.toString() + " * " + expr2.toString() + ")";
	}
	
}
