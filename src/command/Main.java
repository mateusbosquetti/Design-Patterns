package command;

public class Main {
    public static void main(String[] args) {

        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remoteControl = new RemoteControl();
        System.out.println("Ligando...");
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();
        remoteControl.pressUndo();

        System.out.println("Desligando...");
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
        remoteControl.pressUndo();

    }
}
