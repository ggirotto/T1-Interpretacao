package interpretacaoJulio;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		whileStatement();
//		ifAndBoolStatements();
		negStatements();
		
	}

	/*
		This example describes the following program

		a = (10 - 7) + ((3 * 0) + (1 + 2));
		b = false;
		base = 5;

		while (!(a == 100)) {
			if (b) {
				a = a + base;
			} else {
				b = !b;
			}
		}
	 */
	private static void negStatements() {
		Ambiente env = new Ambiente();

		//// a = (10 - 7) + ((3 * 0) + (1 + 1))

		// (10 - 7)
		Subtracao sub1 = new Subtracao(new Literal(10), new Literal(7));
		// (3 * 0)
		Multiplicacao mult1 = new Multiplicacao(new Literal(3), new Literal(0));
		// (1 + 2)
		Soma sum1 = new Soma(new Literal(1), new Literal(1));
		// ((3 * 0) + (1 + 2))
		Soma sum2 = new Soma(mult1, sum1);
		// (10 - 7) + ((3 * 0) + (1 + 2))
		Soma sum3 = new Soma(sub1, sum2);

		VariavelLiteral a = new VariavelLiteral("a", env);
		Atribuicao atr1 = new Atribuicao(a, sum3, env);

		//// b = false
		VariavelBoleana b = new VariavelBoleana("b", env);
		Atribuicao atr2 = new Atribuicao(b, new Booleano(false), env);

		//// base = 5
		VariavelLiteral base = new VariavelLiteral("base", env);
		Atribuicao atr3 = new Atribuicao(base, new Literal(5), env);

		////		while (!(a == 100)) {
		////			if (b) {
		////				a = a + base;
		////			} else {
		////				b = !b;
		////			}
		////		}

		// !(a == 100)
		Igual equal = new Igual(a, new Literal(100));
		Negacao neg1 = new Negacao(equal);

		// a = a + base
		Soma sum4 = new Soma(a, base);
		Atribuicao atr4 = new Atribuicao(a, sum4, env);
		Operacao[] ops1 = {atr4};
		Sequencia seq = new Sequencia(ops1);

		// b = !b
		Negacao neg2 = new Negacao(b);
		Atribuicao atr5 = new Atribuicao(b, neg2, env);
		Operacao[] ops2 = {atr5};
		Sequencia seq2 = new Sequencia(ops2);

		////		if (b) {
		////			a = a + base;
		////		} else {
		////			b = !b;
		////		}

		If ifStatement = new If(b, seq, seq2);

		Operacao[] ops3 = {ifStatement};
		Sequencia seq3 = new Sequencia(ops3);
		While whileStatement = new While(neg1, seq3);

		//// Running
		// First run all attributions
		// a = (10 - 7) + ((3 * 0) + (1 + 2));
		// b = false;
		// base = 5;
		Operacao[] ops4 = {atr1, atr2, atr3};
		Sequencia seq4 = new Sequencia(ops4);

		seq4.computa();

		// Now run the While Statement
		whileStatement.computa();
	}

	/*
		This example describes the following program

		a = 3 > 5;
		b = true;
		c = (a || b) && (false || (5 > 3));
		d = 0;
		mult = 5;
		base = 5;

		if (c) {
			d = mult * base;
		} else {
			d = mult + base;
		}
	 */
	private static void ifAndBoolStatements() {
		Ambiente env = new Ambiente();

		// a = 3 > 5
		VariavelBoleana a = new VariavelBoleana("a", env);
		Maior m = new Maior(new Literal(3), new Literal(5));
		Atribuicao atr1 = new Atribuicao(a, m, env);

		// b = true
		VariavelBoleana b = new VariavelBoleana("b", env);
		Atribuicao atr2 = new Atribuicao(b, new Booleano(true), env);

		// c = (a || b) && (false || (5 > 3));
		VariavelBoleana c = new VariavelBoleana("c", env);

		Ou or = new Ou(a, b);
		Maior m2 = new Maior(new Literal(5), new Literal(3));
		Ou or2 = new Ou(new Booleano(false), m2);
		E and = new E(or, or2);

		Atribuicao atr3 = new Atribuicao(c, and, env);

		// d = 0
		VariavelLiteral d = new VariavelLiteral("d", env);
		Atribuicao atr4 = new Atribuicao(d, new Literal(0), env);

		// mult = 5
		VariavelLiteral mult = new VariavelLiteral("mult", env);
		Atribuicao atr5 = new Atribuicao(mult, new Literal(5), env);

		// base = 5
		VariavelLiteral base = new VariavelLiteral("base", env);
		Atribuicao atr6 = new Atribuicao(base, new Literal(5), env);

		//// if statement

		// d = mult * base;
		Multiplicacao mul = new Multiplicacao(mult, base);
		Atribuicao atr7 = new Atribuicao(d, mul, env);

		Operacao[] ops = {atr7};
		Sequencia seq1 = new Sequencia(ops);

		// d = mult + base
		Soma sum = new Soma(mult, base);
		Atribuicao atr8 = new Atribuicao(d, sum, env);

		Operacao[] ops2 = {atr8};
		Sequencia seq2 = new Sequencia(ops2);

		// if (c) {
		//    d = mult * base;
		// } else {
		//    d = mult + base;
		// }
		If ifStatement = new If(c, seq1, seq2);

		// a = 3 > 5;
		// b = true;
		// c = (a || b) && (false || (5 > 3));
		// d = 0;
		// mult = 5;
		// base = 5;
		Operacao[] ops3 = {atr1, atr2, atr3, atr4, atr5, atr6};
		Sequencia seq3 = new Sequencia(ops3);

		// Running
		// First execute the attributions
		seq3.computa();

		// Then the If Statement
		ifStatement.computa();
	}

	/*
		This example describes the following program

		x = 1;
		y = 5;
		z = 10;
		while (x < 5) {
			x = x + 1;
			z = z - 1;
		}

	 */
	private static void whileStatement() {
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
