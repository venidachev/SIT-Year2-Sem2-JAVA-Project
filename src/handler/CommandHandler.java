package handler;

import filemanager.FileManager;
import res.R;
import shapes.Shape;
import svg.SVGOperations;

import java.util.List;

public class CommandHandler {

    public int handleCommand(String[] args) {
        String command = args[0];
        return switch (command) {
//            Command line commands
            case R.open -> openCommand(args);
            case R.close -> closeCommand();
            case R.save -> saveCommand();
            case R.saveas -> saveasCommand(args);
            case R.help -> helpCommand();
            case R.exit -> exitCommand();
//            SVG commands
            case R.print -> printCommand();
            case R.create -> createCommand(args);
            case R.erase -> eraseCommand(args);
            case R.translate -> translateCommand(args);
            case R.within -> withinCommand(args);
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
    private int saveCommand() {
        FileManager fm = FileManager.getInstance();
        fm.saveFile();
        return 0;
    }
    private int saveasCommand(String[] args) {
        FileManager fm = FileManager.getInstance();
        fm.saveasFile(args[1]);
        return 0;
    }

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
        if (fm.getFileName() == null) {
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

    private int createCommand(String[] args) {
        FileManager fm = FileManager.getInstance();
        if (fm.getFileName() == null) {
            System.out.println(R.errorNoFileOpen);
            return 0;
        }
        SVGOperations.createShape(args);
        return 0;
    }

    private int eraseCommand(String[] args) {
        FileManager fm = FileManager.getInstance();
        fm.removeShape(Integer.parseInt(args[1]));
        return 0;
    }

    private int translateCommand(String[] args) {
        int id;
        try {
//            Translate 1
            id = Integer.parseInt(args[1]);
            SVGOperations.translateShape(id, args);
            System.out.println("Translated shape " + id);
        } catch (ArrayIndexOutOfBoundsException e) {
//            Wrong usage
        } catch (NumberFormatException e) {
//            Translate all
            FileManager fm = FileManager.getInstance();
            List<Shape> shapes = fm.getShapes();
            for (Shape shape : shapes) {
                SVGOperations.translateShape(shapes.indexOf(shape)+1, args);
            }
            System.out.println("Translated all shapes");
        }
        return 0;
    }

    private int withinCommand(String[] args) {

        return 0;
    }
}
