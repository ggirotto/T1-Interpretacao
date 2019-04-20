package interpretacaoJulio;

import java.util.HashMap;

public class Ambiente {
	
	private HashMap<String, Integer> literalEnvironment;
	private HashMap<String, Boolean> booleanEnvironment;
	
	Ambiente() {
		this.literalEnvironment = new HashMap<String, Integer>();
		this.booleanEnvironment = new HashMap<String, Boolean>();
	}
	
	public void addLiteral(String var, Integer value) {
		literalEnvironment.put(var, value);
		System.out.println("Associei o literal " + value + "à variável " + var);
	}
	
	public void addBooleano(String var, Boolean value) {
		booleanEnvironment.put(var, value);
		System.out.println("Associei o booleano " + value + "à variável " + var);
	}
	
	public Integer getLiteral(String key) {
		return literalEnvironment.get(key);
	}
	
	public Boolean getBooleano(String key) {
		return booleanEnvironment.get(key);
	}
}
