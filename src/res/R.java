package res;

public class R {
    public static final String menu = "Menu";
//    Command line commands
    public static final String open = "open";
    public static final String close = "close";
    public static final String save = "save";
    public static final String saveas = "saveas";
    public static final String help = "help";
    public static final String exit = "exit";
//    SVG commands
    public static final String print = "print";
    public static final String create = "create";
    public static final String erase = "erase";
    public static final String translate = "translate";
    public static final String within = "within";

    public static final String exitMessage = "Exiting the program...";
//    Invalid command message
    public static final String invalidMessage = "Invalid command: Use \"help\" for list of commands.";
//    File manager messages
    public static final String successOpen = "Successfully opened ";
    public static final String successClose = "Successfully closed ";
    public static final String successSave = "Successfully saved ";
    public static final String successSaveas = "Successfully saved another ";

    public static final String failOpen = "Fail. File already opened - ";
    public static final String errorNoFileOpen = "Fail. No file is currently opened";

    public static final String errorOpen = "Invalid usage. Correct usage: open <file>";

    public static final String createSuccess = "Successfully created ";
    public static final String eraseSuccess = "Erased a ";

//    SVGParse messages
    public static final String newFileSuccess = "New file created";
    public static final String newFileFail = "Failed to create new file";
//    Supported shapes
    public static final String rect = "<rect";
    public static final String circle = "<circle";
    public static final String line = "<line";
}
