package state;

public interface TaskState {

    TaskState start();
    TaskState finish();
    TaskState cancel();

}
