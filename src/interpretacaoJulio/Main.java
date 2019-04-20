package interpretacaoJulio;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ambiente env = new Ambiente();
		Literal three = new Literal(3);
		Literal four = new Literal(4);
		Literal five = new Literal(5);
		Soma sum1 = new Soma(three, four);
		Soma sum2 = new Soma(sum1, five);
		Atribuicao atr = new Atribuicao("x", sum2, env);
		
		atr.computa();
	}

}
