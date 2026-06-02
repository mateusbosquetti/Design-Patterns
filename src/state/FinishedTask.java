package state;

public class FinishedTask implements TaskState {

    @Override
    public TaskState start() {
        System.out.println("Erro, nao pode iniciar tarefa ja finalizada...");
        return this;
    }

    @Override
    public TaskState finish() {
        System.out.println("Erro, nao pode finalizar tarefa ja finalizada...");
        return this;
    }

    @Override
    public TaskState cancel() {
        System.out.println("Erro, nao pode cancelar tarefa ja finalizada...");
        return this;
    }
}
