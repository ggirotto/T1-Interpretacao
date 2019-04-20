package interpretacaoJulio;

public class Maior implements ExpressaoBooleana {
	
	private ExpressaoAritmetica expr1;
	private ExpressaoAritmetica expr2;
	
	Maior(ExpressaoAritmetica expr1, ExpressaoAritmetica expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public Boolean computa() {
		System.out.println("Avaliando Maior Lógico " + toString());
		Boolean result = expr1.computa() > expr2.computa();
		System.out.println("Resultado do Maior Lógico " + toString() + " em " + result);
		return result;
	}
	
	@Override
	public String toString() {
		return "(" + expr1.toString() + " > " + expr2.toString() + ")";
	}
	
}
