package res;

public class R {
    public static final String menu = "Menu";
//    Commands
    public static final String open = "open";
    public static final String close = "close";
    public static final String save = "save";
    public static final String saveas = "saveas";
    public static final String help = "help";
    public static final String exit = "exit";
//    Help message
    public static final String helpMessage = """
        The following commands are supported:
        open <file>      opens <file>
        close            closes currently opened file
        save             saves the currently open file
        saveas <file>    saves the currently open file in <file>
        help             prints this information
        exit             exits the program""";
//    Exit message
    public static final String exitMessage = "Exiting the program...";
//    Invalid command message
    public static final String invalidMessage = "Invalid command: Use \"help\" for list of commands.";
//    File manager messages
    public static final String successOpen = "Successfully opened ";
    public static final String successClose = "Successfully closed ";
    public static final String successSave = "Successfully saved ";
    public static final String successSaveas = "Successfully saved another ";

    public static final String failOpen = "Fail. File already opened - ";
    public static final String failClose = "Fail. No file is currently opened";

    public static final String errorOpen = "Invalid usage. Correct usage: open <file>";
}
