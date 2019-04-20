package interpretacaoJulio;

public class While implements Operacao {

	private ExpressaoBooleana condition;
	private Sequencia body;
	
	While(ExpressaoBooleana condition, Sequencia body) {
		this.condition = condition;
		this.body = body;
	}
	
	@Override
	public void computa() {
		System.out.println("Avaliando While com condicao " + condition.toString() + " e corpo " + body.toString());
		Boolean conditionResult = condition.computa();
		System.out.println("Expressao do While avaliada em " + conditionResult);
		if (conditionResult) {
			body.computa();
			computa();
		}
	}
	
	@Override
	public String toString() {
		return "While(" + condition.toString() + ")" + "do { " + body.toString() + " }";
	}
	
}
