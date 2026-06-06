package Utilitarios;

public class Utilitarios {
    public static void delay(int tempo){
        try {
            Thread.sleep((tempo*1000));
        } catch (InterruptedException e) {
            System.out.println("Erro na produção");
        }
    }
}
