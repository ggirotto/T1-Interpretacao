package interpretacaoJulio;

public class Variavel<T> implements Expressao<T> {

	public String associatedValue;
	private Ambiente environment;
	
	Variavel(String associatedValue, Ambiente environment) {
		this.associatedValue = associatedValue;
		this.environment = environment;
	}
	
	@Override
	public T computa() {
		VarType type = environment.getType(this);
		
		switch (type) {
		case Literal:
			Integer result = environment.getLiteral(this);
			return (T)result;
		case Booleano:
			Boolean resultb = environment.getBooleano(this);
			return (T)resultb;
		default: return null;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
