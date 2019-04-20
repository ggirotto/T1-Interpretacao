package interpretacaoJulio;

public class VariavelBoleana implements Variavel, ExpressaoBooleana {
	
	public String associatedValue;
	private Ambiente environment;
	
	VariavelBoleana(String associatedValue, Ambiente environment) {
		this.associatedValue = associatedValue;
		this.environment = environment;
	}
	
	@Override
	public Boolean computa() {
		return environment.getBooleano(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
