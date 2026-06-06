package Equipamentos.Especificos;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Interfaces.Calibracao;
import Equipamentos.Interfaces.Teste;
import Utilitarios.Utilitarios;

public class VentiladorPulmonar extends Equipamento implements Calibracao, Teste {

    public VentiladorPulmonar(){
        super("Ventilador Pulmonar", 4);
    }

    @Override
    public void calibracao(){
        System.out.println("Calibrando pressão barométrica...");
        Utilitarios.delay(1);
        System.out.println("Calibrando proporções de O2, CO2 e Ni...");
        Utilitarios.delay(1);
        System.out.println("Ventilador pulmonar calibrado.");
        Utilitarios.delay(1);
    }

    @Override
    public void testandoFuncionamento(){
        System.out.println("Testando sensores...");
        Utilitarios.delay(1);
        System.out.println("Testando pressão barométrica...");
        Utilitarios.delay(1);
        System.out.println("Testando proporções de mistura do ar...");
        Utilitarios.delay(1);
        System.out.println("Procurando vazamentos...");
        Utilitarios.delay(1);
        System.out.println("Testes concluídos para ventilador pulmonar, equipamento número " + getId() + ".");
        Utilitarios.delay(1);
    }

}
