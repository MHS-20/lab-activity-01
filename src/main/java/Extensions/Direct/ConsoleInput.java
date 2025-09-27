package Extensions.Direct;

import java.util.Scanner;
import common.Controller;

public class ConsoleInput {
    private Controller controller;

    public ConsoleInput(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Premi INVIO per incrementare lo stato, 'q' per uscire.");
        while (true) {
            String input = scanner.nextLine();
            if ("q".equalsIgnoreCase(input)) break;
            controller.increment();
        }
        scanner.close();
    }
}
