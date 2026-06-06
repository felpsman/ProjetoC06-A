package Equipamentos.Especificos;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Interfaces.Calibracao;
import Equipamentos.Interfaces.Esterilizacao;
import Equipamentos.Interfaces.Teste;
import Utilitarios.Utilitarios;

public class BisturiEletrico extends Equipamento implements Esterilizacao, Calibracao, Teste {

    public BisturiEletrico() {
        super("Bisturi elétrico", 3);
    }

    @Override
    public void esterilizando(){
        System.out.println("Esterilizando ponteira...");
        Utilitarios.delay(1);
        System.out.println("Esterilizando caneta porta-elétrodo...");
        Utilitarios.delay(1);
        System.out.println("Bisturi elétrico (ID: " + getId() + ") " + "esterilizado");
        Utilitarios.delay(1);
    }

    @Override
    public void calibracao(){
        System.out.println("Calibrando potência de saída...");
        Utilitarios.delay(1);
        System.out.println("Bisturi elétrico calibrado.");
        Utilitarios.delay(1);
    }

    @Override
    public void testandoFuncionamento(){
        System.out.println("Testando potência de saída...");
        Utilitarios.delay(1);
        System.out.println("Testando isolamento elétrico...");
        Utilitarios.delay(1);
        System.out.println(("Testes concluídos para bisturi elétrico, equipamento número " + getId() + "."));
        Utilitarios.delay(1);
    }
}

