package interpretacaoJulio;

public class If implements Operacao {
	
	private ExpressaoBooleana condition;
	private Sequencia bodyTrue;
	private Sequencia bodyFalse;
	
	
	If(ExpressaoBooleana condition, Sequencia bodyTrue, Sequencia bodyFalse) {
		this.condition = condition;
		this.bodyTrue = bodyTrue;
		this.bodyFalse = bodyFalse;
	}
	
	@Override
	public void computa() {
		System.out.println("Avaliando If com condicao " + condition.toString() + " caso verdadeiro " + bodyTrue.toString() + " caso falso " + bodyFalse.toString());
		Boolean conditionResult = condition.computa();
		System.out.println("Expressao do If avaliada em " + conditionResult);
		if (conditionResult) {
			bodyTrue.computa();
		} else {
			bodyFalse.computa();
		}
	}
	
	@Override
	public String toString() {
		return "If(" + condition.toString() + ")" + "then { " + bodyTrue.toString() + " } else { " + bodyFalse.toString() + " }";
	}
}
