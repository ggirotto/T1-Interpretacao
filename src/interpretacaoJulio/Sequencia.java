package interpretacaoJulio;

public class Sequencia implements Operacao {
	
	private Operacao[] operations;
	
	Sequencia(Operacao[] operations) {
		this.operations = operations;
	}
	
	@Override
	public void computa() {
		for (Operacao operation : operations) {
			operation.computa();
		}
	}
	
	@Override
	public String toString() {
		String result = "Computando em sequencia: ";
		for (Operacao operation : operations) {
			result += operation.toString() + "; ";
		}
		return result;
	}
}
