package Producao;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Especificos.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LinhaDeProducao {

    private ArrayList<Equipamento> equipamentos;

    public LinhaDeProducao() {

        equipamentos = new ArrayList<>();
    }

    public void carregarPedido(String arquivo)
            throws Exception {

        List<String> linhas =
                Files.readAllLines(
                        Path.of(arquivo)
                );

        for (String linha : linhas) {

            linha = linha.trim();

            switch (linha.toUpperCase()) {

                case "VENTILADOR":

                    equipamentos.add(
                            new VentiladorPulmonar()
                    );
                    break;

                case "DESFIBRILADOR":

                    equipamentos.add(
                            new Desfibrilador()
                    );
                    break;

                case "BISTURI":

                    equipamentos.add(
                            new BisturiEletrico()
                    );
                    break;

                case "MOTOR":

                    equipamentos.add(
                            new MotorCirurgico()
                    );
                    break;

                default:

                    throw new ExcecaoProducao(
                            "Equipamento inválido: "
                                    + linha
                    );
            }
        }

        if (equipamentos.isEmpty()) {

            throw new ExcecaoProducao(
                    "Pedido vazio."
            );
        }
    }

    public void iniciarProducao()
            throws InterruptedException {

        ArrayList<EsteiraProducao> threads =
                new ArrayList<>();

        System.out.println(
                "\n===== INICIANDO PRODUÇÃO ====="
        );

        for (Equipamento equipamento
                : equipamentos) {

            EsteiraProducao thread =
                    new EsteiraProducao(
                            equipamento
                    );

            threads.add(thread);

            thread.start();
        }

        for (EsteiraProducao thread
                : threads) {

            thread.join();
        }

        Equipamento.resetContagem();

        System.out.println(
                "\n===== PRODUÇÃO FINALIZADA ====="
        );
    }
}