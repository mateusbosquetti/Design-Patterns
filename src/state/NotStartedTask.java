package state;

public class NotStartedTask implements TaskState {

    @Override
    public TaskState start() {
        System.out.println("Iniciando tarefa...");
        return new RunningTask();
    }

    @Override
    public TaskState finish() {
        System.out.println("Erro, nao podemos finalizar algo não iniciado");
        return this;
    }

    @Override
    public TaskState cancel() {
        System.out.println("Cancelando tarefa...");
        return new CanceledTask();
    }
}
