package interpretacaoJulio.TiposPrimitivos;

import interpretacaoJulio.Interfaces.ExpressaoAritmetica;

public class Literal implements ExpressaoAritmetica {
	
	private Integer associatedValue;

	public Literal(Integer value) {
		this.associatedValue = value;
	}
	
	@Override
	public Integer computa() {
		System.out.println("Avaliei o literal " + this.associatedValue);
		return this.associatedValue;
	}
	
	@Override
	public String toString() {
		return associatedValue.toString();
	}
}
