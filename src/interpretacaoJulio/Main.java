package interpretacaoJulio;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ambiente env = new Ambiente();
		Literal one = new Literal(1);
		Literal five = new Literal(5);
		Literal five2 = new Literal(5);
		Literal ten = new Literal(10);
		
		VariavelLiteral x = new VariavelLiteral("x", env);
		VariavelLiteral y = new VariavelLiteral("y", env);
		VariavelLiteral z = new VariavelLiteral("z", env);
		
		
		Atribuicao atr1 = new Atribuicao(x, one, env);
		Atribuicao atr2 = new Atribuicao(y, five, env);
		Atribuicao atr3 = new Atribuicao(z, ten, env);
		
		Menor m = new Menor(x,five2);
		
		Soma b1 = new Soma(x,new Literal(1));
		Atribuicao atr4 = new Atribuicao(x, b1, env);
		
		Subtracao b2 = new Subtracao(z,new Literal(1));
		Atribuicao atr5 = new Atribuicao(z, b2, env);
		
		Operacao[] ops = {atr4, atr5};
		Sequencia seq = new Sequencia(ops);
		
		While w = new While(m, seq);
		
		Operacao[] finalOps = {atr1, atr2, atr3, w};
		Sequencia finalSeq = new Sequencia(finalOps);
		
		finalSeq.computa();
		
		
	}

}
