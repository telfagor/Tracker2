package start;

import input.ConsoleInput;
import input.Input;
import model.tracker.Tracker;

public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().start(input, tracker);
    }
}
