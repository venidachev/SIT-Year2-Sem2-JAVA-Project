import handler.CommandHandler;
import handler.MessageHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CommandHandler ch = new CommandHandler();
        MessageHandler mh = new MessageHandler();
        while (true) {
            String[] command  = sc.nextLine().split(" ");
            int res = ch.handleCommand(command);
            mh.handleMessage(res);
            if(res == 1) {
                break;
            }
        }
    }
}