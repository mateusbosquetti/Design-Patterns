package state;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Cenário 1: Fluxo Feliz ---");
        Task task1 = new Task();
        task1.start();  // NotStarted -> Running
        task1.finish(); // Running -> Finished

        System.out.println("\n--- Cenário 2: Cancelamento Direto ---");
        Task task2 = new Task();
        task2.cancel(); // NotStarted -> Canceled
        task2.start();  // Erro: cancelado

        System.out.println("\n--- Cenário 3: Iniciar e depois Cancelar ---");
        Task task3 = new Task();
        task3.start();  // NotStarted -> Running
        task3.cancel(); // Running -> Canceled
        task3.finish(); // Erro: cancelado

        System.out.println("\n--- Cenário 4: Tentativas Inválidas ---");
        Task task4 = new Task();
        task4.finish(); // Erro: não iniciado
        task4.start();  // Sucesso: NotStarted -> Running
        task4.start();  // Erro: já iniciado
    }
}
