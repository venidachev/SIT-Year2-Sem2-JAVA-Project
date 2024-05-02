import res.R;
import shapes.Shape;

import java.util.List;

public class CommandHandler {

    public int handleCommand(String[] args) {
        String command = args[0];
        return switch (command) {
//            Command line commands
            case R.open -> openCommand(args);
            case R.close -> closeCommand();
            case R.save -> saveCommand();
            case R.saveas -> saveasCommand();
            case R.help -> helpCommand();
            case R.exit -> exitCommand();
//            SVG commands
            case R.print -> printCommand();
            case R.create -> createCommand();
            case R.erase -> eraseCommand();
            case R.translate -> translateCommand();
            case R.within -> withinCommand();
            default -> {
                System.out.println(R.invalidMessage);
                yield 0;
            }
        };
    }
//    Command line commands
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
//    SVG file commands
    private int printCommand() {
        FileManager fm = FileManager.getInstance();
        if (fm.getCurrentFile() == null) {
            System.out.println(R.errorNoFileOpen);
            return 0;
        }
        List<Shape> shapes = fm.getShapes();
        int i = 0;
        for (Shape shape: shapes) {
            System.out.println(++i+". "+shape.toPrint());
        }

        return 0;
    }

    private int createCommand() {

        return 0;
    }

    private int eraseCommand() {

        return 0;
    }

    private int translateCommand() {

        return 0;
    }

    private int withinCommand() {

        return 0;
    }
}
