package state;

public class Task {

    private TaskState status;

    public Task() {
        this.status = new NotStartedTask();
    }

    public void start() {
        this.status = status.start();
    }

    public void finish() {
        this.status = status.finish();
    }

    public void cancel() {
        this.status = status.cancel();
    }

}
