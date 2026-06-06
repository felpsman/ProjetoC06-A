package Equipamentos.Especificos;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Interfaces.Calibracao;
import Equipamentos.Interfaces.Esterilizacao;
import Equipamentos.Interfaces.Teste;
import Utilitarios.Utilitarios;

public class MotorCirurgico extends Equipamento implements Esterilizacao, Calibracao, Teste {

    public MotorCirurgico(){
        super("Motor cirurgico", 4);
    }

    @Override
    public void esterilizando(){
        System.out.println("Esterilizando cabo...");
        Utilitarios.delay(1);
        System.out.println("Esterilizando broca...");
        Utilitarios.delay(1);
        System.out.println("Motor cirúrgico (ID: " + getId() + ") " + "esterilizado");
        Utilitarios.delay(1);
    }

    @Override
    public void calibracao(){
        System.out.println("Calibrando velocidade máxima...");
        Utilitarios.delay(1);
        System.out.println("Calibrando potência maxima...");
        Utilitarios.delay(1);
        System.out.println("Motor cirúrgico calibrado.");
        Utilitarios.delay(1);
    }

    @Override
    public void testandoFuncionamento(){
        System.out.println("Testando potência máxima...");
        Utilitarios.delay(1);
        System.out.println("Testando integridade da estrutura com torque e velocidade máximos...");
        Utilitarios.delay(1);
        System.out.println(("Testes concluídos para motor cirúrgico, equipamento número " + getId() + "."));
        Utilitarios.delay(1);
    }
}
