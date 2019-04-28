package interpretacaoJulio.Operacoes;

import interpretacaoJulio.Interfaces.Operacao;

public class Skip implements Operacao {

    public Skip() { }

    @Override
    public void computa() {
        System.out.println("Computando SKIP");
    }
}
