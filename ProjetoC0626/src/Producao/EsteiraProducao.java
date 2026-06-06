package Producao;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Interfaces.Calibracao;
import Equipamentos.Interfaces.Esterilizacao;
import Equipamentos.Interfaces.Teste;

public class EsteiraProducao extends Thread {

    private Equipamento equipamento;

    public EsteiraProducao(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public void run() {

        try {

            System.out.println("\n=================================");
            System.out.println(
                    Thread.currentThread().getName()
                            + " produzindo "
                            + equipamento.getNome()
                            + " (ID "
                            + equipamento.getId()
                            + ")"
            );
            System.out.println("=================================");

            /*
             * Simulação do tempo de produção
             */

            Thread.sleep(
                    equipamento.getTempo() * 1000L
            );

            /*
             * Esterilização
             */

            if (equipamento instanceof Esterilizacao) {

                ((Esterilizacao) equipamento)
                        .esterilizando();
            }

            /*
             * Calibração
             */

            if (equipamento instanceof Calibracao) {

                ((Calibracao) equipamento)
                        .calibracao();
            }

            /*
             * Testes
             */

            if (equipamento instanceof Teste) {

                ((Teste) equipamento)
                        .testandoFuncionamento();
            }

            System.out.println(
                    equipamento.getNome()
                            + " finalizado com sucesso."
            );

        }
        catch (InterruptedException e) {

            System.out.println(
                    "Thread interrompida durante a produção."
            );
        }
        catch (Exception e) {

            System.out.println(
                    "Erro durante produção de "
                            + equipamento.getNome()
            );

            System.out.println(
                    e.getMessage()
            );
        }
    }
}