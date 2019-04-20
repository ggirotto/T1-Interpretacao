package interpretacaoJulio.Operacoes;

import interpretacaoJulio.Ambiente;
import interpretacaoJulio.TiposPrimitivos.Booleano;
import interpretacaoJulio.Interfaces.*;
import interpretacaoJulio.TiposPrimitivos.Literal;

public class Atribuicao implements Operacao {
	
	private Variavel associatedVar;
	private Expressao expression;
	private Ambiente environment;
	
	public Atribuicao(Variavel associatedVar, Expressao expression, Ambiente environment) {
		this.associatedVar = associatedVar;
		this.expression = expression;
		this.environment = environment;
	}
	
	@Override
	public void computa() {
		if (expression instanceof Literal) {
			Literal castedExpression = (Literal)expression;
			Integer result = castedExpression.computa();
			environment.addLiteral(associatedVar, result);
		} else if (expression instanceof Booleano) {
			Booleano castedExpression = (Booleano)expression;
			Boolean result = castedExpression.computa();
			environment.addBooleano(associatedVar, result);
		} else if (expression instanceof ExpressaoAritmetica) {
			ExpressaoAritmetica castedExpression = (ExpressaoAritmetica)expression;
			Integer result = castedExpression.computa();
			environment.addLiteral(associatedVar, result);
		} else if (expression instanceof ExpressaoBooleana) {
			ExpressaoBooleana castedExpression = (ExpressaoBooleana)expression;
			Boolean result = castedExpression.computa();
			environment.addBooleano(associatedVar, result);
		}
	}
	
	@Override
	public String toString() {
		return associatedVar.toString() + " = " + expression.toString();
	}
}
