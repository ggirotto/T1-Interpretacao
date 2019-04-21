package interpretacaoJulio;

import interpretacaoJulio.Interfaces.Variavel;
import java.util.HashMap;
import java.util.Map;

enum VarType {
	Literal, Booleano
}

public class Ambiente {
	
	private HashMap<Variavel, Integer> literalEnvironment;
	private HashMap<Variavel, Boolean> booleanEnvironment;
	
	public Ambiente() {
		this.literalEnvironment = new HashMap<Variavel, Integer>();
		this.booleanEnvironment = new HashMap<Variavel, Boolean>();
	}
	
	public void addLiteral(Variavel var, Integer value) {
		literalEnvironment.put(var, value);
		System.out.println("Associei o literal " + value + " à variável " + var);
	}
	
	public void addBooleano(Variavel var, Boolean value) {
		booleanEnvironment.put(var, value);
		System.out.println("Associei o booleano " + value + " à variável " + var);
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

	@Override
	public String toString() {
		String message = "";
		message += "######################################\n";
		message += "Estado das variáveis do ambiente\n";
		for (Map.Entry<Variavel, Integer> entry : literalEnvironment.entrySet()) {
			message += "Variável " + entry.getKey().toString() + " avaliada em " + entry.getValue().toString() + "\n";
		}
		for (Map.Entry<Variavel, Boolean> entry : booleanEnvironment.entrySet()) {
			message += "Variável " + entry.getKey().toString() + " avaliada em " + entry.getValue().toString() + "\n";
		}
		return message;
	}
}
