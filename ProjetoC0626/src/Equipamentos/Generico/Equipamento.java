package Equipamentos.Generico;

import Utilitarios.Utilitarios;

public abstract class Equipamento {

    //variaveis comums
    private String nome;
    private int tempoProducao;
    private int id;
    private static int contador;

    //construtor
    public Equipamento(String nome, int tempoProducao){
        this.nome = nome;
        this.tempoProducao = tempoProducao;
        contador++;
        this.id = contador;
        Utilitarios.delay(this.tempoProducao);
    }

    //resetar id quando a linha de produção do pedido acabar
    public static void resetContagem(){
        contador = 0;
    }

    //getters
    public String getNome(){
        return nome;
    }

    public int getTempo(){
        return tempoProducao;
    }

    public int getId(){
        return id;
    }

}
