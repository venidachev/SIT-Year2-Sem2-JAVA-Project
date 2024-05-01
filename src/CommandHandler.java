import res.R;

public class CommandHandler {

    public int handleCommand(String[] args) {
        String command = args[0];
        return switch (command) {
            case R.open -> openCommand(args);
            case R.close -> closeCommand();
            case R.save -> saveCommand();
            case R.saveas -> saveasCommand();
            case R.help -> helpCommand();
            case R.exit -> exitCommand();
            default -> {
                System.out.println(R.invalidMessage);
                yield 0;
            }
        };
    }

    private int openCommand(String[] args) {
        try {
            FileManager fm = FileManager.getInstance();
            fm.openFile(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(R.errorOpen);
        }
        return 0;
    }
    private int closeCommand() {
        FileManager fm = FileManager.getInstance();
        fm.closeFile();
        return 0;
    }
    private int saveCommand() { return 0; }
    private int saveasCommand() { return 0; }

    private int helpCommand() {
        System.out.println(R.helpMessage);
        return 0;
    }

    private int exitCommand() {
        System.out.println(R.exitMessage);
        return 1;
    }
}
