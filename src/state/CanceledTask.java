package state;

public class CanceledTask implements TaskState {

    @Override
    public TaskState start() {
        System.out.println("Erro, nao podemos iniciar algo cancelado");
        return this;
    }

    @Override
    public TaskState finish() {
        System.out.println("Erro, nao podemos finalizar algo cancelado");
        return this;
    }

    @Override
    public TaskState cancel() {
        System.out.println("Erro, nao podemos cancelar algo cancelado");
        return this;
    }
}
