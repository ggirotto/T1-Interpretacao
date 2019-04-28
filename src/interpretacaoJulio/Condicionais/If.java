package interpretacaoJulio.Condicionais;

import interpretacaoJulio.Interfaces.ExpressaoBooleana;
import interpretacaoJulio.Interfaces.Operacao;
import interpretacaoJulio.Variaveis.VariavelBoleana;

public class If implements Operacao {
	
	private ExpressaoBooleana condition;
	private Operacao bodyTrue;
	private Operacao bodyFalse;
	
	
	public If(ExpressaoBooleana condition, Operacao bodyTrue, Operacao bodyFalse) {
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
