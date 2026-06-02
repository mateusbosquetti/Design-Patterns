package state;

public class RunningTask implements TaskState {

    @Override
    public TaskState start() {
        System.out.println("Erro, nao pode iniciar algo ja iniciado...");
        return this;
    }

    @Override
    public TaskState finish() {
        System.out.println("Finalizando tarefa...");
        return new FinishedTask();
    }

    @Override
    public TaskState cancel() {
        System.out.println("Cancelando tarefa...");
        return new CanceledTask();
    }
}
