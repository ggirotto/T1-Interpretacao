package interpretacaoJulio;

public class Subtracao implements ExpressaoAritmetica {
	
	private ExpressaoAritmetica expr1;
	private ExpressaoAritmetica expr2;
	
	Subtracao(ExpressaoAritmetica expr1, ExpressaoAritmetica expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public Integer computa() {
		System.out.println("Avaliando Subtracao " + toString());
		Integer result = expr1.computa() - expr2.computa();
		System.out.println("Resultado da Subtracao " + toString() + " em " + result);
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + expr1.toString() + " - " + expr2.toString() + ")";
	}
	
}
