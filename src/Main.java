import handler.CommandHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CommandHandler ch = new CommandHandler();
        while (true) {
            String[] command  = sc.nextLine().split(" ");
            if(ch.handleCommand(command) == 1) {
                break;
            }
        }
    }
}