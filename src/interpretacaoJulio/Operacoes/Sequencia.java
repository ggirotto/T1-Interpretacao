package interpretacaoJulio.Operacoes;

import interpretacaoJulio.Interfaces.Operacao;

public class Sequencia implements Operacao {
	
	private Operacao firstOperation;
	private Operacao secondOperation;
	
	public Sequencia(Operacao firstOperation, Operacao secondOperation) {
		this.firstOperation= firstOperation;
		this.secondOperation = secondOperation;
	}
	
	@Override
	public void computa() {
		firstOperation.computa();
		secondOperation.computa();
	}
	
	@Override
	public String toString() {
		String result = "Computando em sequencia: ";
		result += firstOperation.toString() + "; ";
		result += secondOperation.toString() + "; ";
		return result;
	}
}
