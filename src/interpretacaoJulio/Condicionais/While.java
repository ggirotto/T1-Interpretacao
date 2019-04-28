package interpretacaoJulio.Condicionais;

import interpretacaoJulio.Interfaces.ExpressaoBooleana;
import interpretacaoJulio.Interfaces.Operacao;
import interpretacaoJulio.Operacoes.Sequencia;

public class While implements Operacao {

	private ExpressaoBooleana condition;
	private Operacao body;
	
	public While(ExpressaoBooleana condition, Operacao body) {
		this.condition = condition;
		this.body = body;
	}
	
	@Override
	public void computa() {
		System.out.println("Avaliando While com condicao " + condition.toString() + " e corpo " + body.toString());
		Boolean conditionResult = condition.computa();
		System.out.println("Condição do While avaliada em " + conditionResult);
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
