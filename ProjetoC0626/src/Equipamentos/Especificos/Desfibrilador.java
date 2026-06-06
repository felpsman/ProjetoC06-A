package Equipamentos.Especificos;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Interfaces.Calibracao;
import Equipamentos.Interfaces.Teste;
import Utilitarios.Utilitarios;

public class Desfibrilador extends Equipamento implements Calibracao, Teste {

    public Desfibrilador(){
        super("Desfibrilador automático", 5);
    }

    @Override
    public void calibracao(){
        System.out.println("Calibrando descarga elétrica...");
        Utilitarios.delay(1);
        System.out.println("Calibrando sensores de batimento cardíaco...");
        Utilitarios.delay(1);
        System.out.println("Desfibrilador automático calibrado.");
        Utilitarios.delay(1);
    }

    @Override
    public void testandoFuncionamento(){
        System.out.println("Testando sensores de batimento cardíaco...");
        Utilitarios.delay(1);
        System.out.println("Testando descarga elétrica...");
        Utilitarios.delay(1);
        System.out.println("Testando área de contato...");
        Utilitarios.delay(1);
        System.out.println(("Testes concluídos para desfibrilador automático, equipamento número " + getId() + "."));
        Utilitarios.delay(1);
    }
}
