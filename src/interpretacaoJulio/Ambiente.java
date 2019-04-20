package interpretacaoJulio;

import java.util.HashMap;

enum VarType {
	Literal, Booleano
}

public class Ambiente {
	
	private HashMap<Variavel, Integer> literalEnvironment;
	private HashMap<Variavel, Boolean> booleanEnvironment;
	
	Ambiente() {
		this.literalEnvironment = new HashMap<Variavel, Integer>();
		this.booleanEnvironment = new HashMap<Variavel, Boolean>();
	}
	
	public void addLiteral(Variavel var, Integer value) {
		literalEnvironment.put(var, value);
		System.out.println("Associei o literal " + value + "à variável " + var);
	}
	
	public void addBooleano(Variavel var, Boolean value) {
		booleanEnvironment.put(var, value);
		System.out.println("Associei o booleano " + value + "à variável " + var);
	}
	
	public Integer getLiteral(Variavel key) {
		return literalEnvironment.get(key);
	}
	
	public Boolean getBooleano(Variavel key) {
		return booleanEnvironment.get(key);
	}
	
	public VarType getType(Variavel key) {
		if (literalEnvironment.containsKey(key)) {
			return VarType.Literal;
		}
		return VarType.Booleano;
	}
	
//	public Variavel getAssociatedVar(String value) {
//		for (Variavel searchKey : literalEnvironment.keySet()) {
//			if (searchKey.associatedValue == value) { return searchKey; }
//		}
//		
//		for (Variavel searchKey : booleanEnvironment.keySet()) {
//			if (searchKey.associatedValue == value) { return searchKey; }
//		}
//		
//		System.out.println("NUNCA DEVE CAIR AQUI!");
//		return new Variavel("DASDASDA", this);
//	}
}
