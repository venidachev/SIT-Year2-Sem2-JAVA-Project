package handler;

public class MessageHandler {
    private final String exit = "Exiting the program...";
    private final String help = """
        The following commands are supported:
        open <file>      opens <file>
        close            closes currently opened file
        save             saves the currently open file
        saveas <file>    saves the currently open file in <file>
        help             prints this information
        exit             exits the program""";
    private final String invalidCommand = "Invalid command: Use \"help\" for list of commands.";
    private final String noFileError = "No file is currently opened.";
    private final String

    public void handleMessage(int id) {
        switch (id) {
            case 1 -> System.out.println(exit);
            case 2 -> System.out.println(help);
            case 3 -> System.out.println(invalidCommand);
            case 20 -> System.out.println(noFileError);
        }
    }
}
