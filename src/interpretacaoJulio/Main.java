package interpretacaoJulio;

import interpretacaoJulio.Condicionais.If;
import interpretacaoJulio.Condicionais.While;
import interpretacaoJulio.Operacoes.Atribuicao;
import interpretacaoJulio.Operacoes.Sequencia;
import interpretacaoJulio.Operacoes.OperacoesAritmeticas.Multiplicacao;
import interpretacaoJulio.Operacoes.OperacoesAritmeticas.Soma;
import interpretacaoJulio.Operacoes.OperacoesAritmeticas.Subtracao;
import interpretacaoJulio.Operacoes.OperacoesBooleanas.*;
import interpretacaoJulio.TiposPrimitivos.Booleano;
import interpretacaoJulio.TiposPrimitivos.Literal;
import interpretacaoJulio.Variaveis.VariavelBoleana;
import interpretacaoJulio.Variaveis.VariavelLiteral;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		whileStatement();
//		ifAndBoolStatements();
		negStatements();
//		teste();
		
	}

	private static void teste() {
		Soma sum0 = new Soma(new Literal(3), new Literal(5));
		Soma sum1 = new Soma(new Literal(4), new Literal(12));
		Soma sum3 = new Soma(sum0, sum1);
		sum3.computa();
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

		// b = !b
		Negacao neg2 = new Negacao(b);
		Atribuicao atr5 = new Atribuicao(b, neg2, env);

		////		if (b) {
		////			a = a + base;
		////		} else {
		////			b = !b;
		////		}

		If ifStatement = new If(b, atr4, atr5);

		While whileStatement = new While(neg1, ifStatement);

		//// Running
		// First run all attributions
		// a = (10 - 7) + ((3 * 0) + (1 + 2));
		// b = false;
		// base = 5;
		Sequencia seq1 = new Sequencia(atr1, atr2);
		Sequencia seq2 = new Sequencia(seq1, atr3);

		seq2.computa();

		// Now run the While Statement
		whileStatement.computa();

		System.out.println(env.toString());
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

		// d = mult + base
		Soma sum = new Soma(mult, base);
		Atribuicao atr8 = new Atribuicao(d, sum, env);

		// if (c) {
		//    d = mult * base;
		// } else {
		//    d = mult + base;
		// }
		If ifStatement = new If(c, atr7, atr8);

		// a = 3 > 5;
		// b = true;
		// c = (a || b) && (false || (5 > 3));
		// d = 0;
		// mult = 5;
		// base = 5;
		Sequencia seq1 = new Sequencia(atr1, atr2);
		Sequencia seq2 = new Sequencia(seq1, atr3);
		Sequencia seq3 = new Sequencia(seq2, atr4);
		Sequencia seq4 = new Sequencia(seq3, atr5);
		Sequencia seq5 = new Sequencia(seq4, atr6);

		// Running
		// First execute the attributions
		seq5.computa();

		// Then the If Statement
		ifStatement.computa();

		System.out.println(env.toString());
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

		Sequencia seq = new Sequencia(atr4, atr5);

		While w = new While(m, seq);

		Sequencia seq2 = new Sequencia(atr1, atr2);
		Sequencia seq3 = new Sequencia(seq2, atr3);
		Sequencia seq4 = new Sequencia(seq3, w);

		seq4.computa();

		System.out.println(env.toString());
	}

}
