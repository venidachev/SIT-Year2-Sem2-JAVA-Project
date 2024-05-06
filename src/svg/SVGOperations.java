package svg;

import filemanager.FileManager;
import res.R;
import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;
import shapes.Shape;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SVGOperations {

    public SVGOperations() {}

    public String parseStartOfFile(Path path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (parseShape(line.trim()) != null) {
                    break;
                }
                sb.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            return "<svg>";
        } catch (IOException _) {
            return null;
        }
        return sb.toString();
    }

    public List<Shape> parseFile(Path path) {
        List<Shape> shapes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                Shape shape = parseShape(line);
                if (shape != null) {
                    shapes.add(shape);
                }
            }
        } catch (FileNotFoundException e) {
//            Create new file if no such file exists
            File newFile = path.toFile();
            try {
                if (newFile.createNewFile()) {
                    System.out.println(R.newFileSuccess);
                } else {
                    System.out.println(R.newFileFail);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return shapes;
    }
    public Shape parseShape(String svg) {
        if (svg.startsWith(R.rect)) return Rectangle.createRectangleFromSVG(svg);
        if (svg.startsWith(R.circle)) return Circle.createCircleFromSVG(svg);
        if (svg.startsWith(R.line)) return Line.createLineFromSVG(svg);
        return null;
    }

    public static void createShape(String[] args) {
        FileManager fm = FileManager.getInstance();
        if (args[1].equals("rectangle")) fm.addShape(new Rectangle(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), args[6]));
        if (args[1].equals("circle")) fm.addShape(new Circle(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), args[5]));
        if (args[1].equals("line")) fm.addShape(new Line(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]), args[7]));
        int id = fm.getShapes().size();
        System.out.println(R.createSuccess + args[1] + " (" + id + ")");
    }

    public static void translateShape(int shapeID, String[] args) {
        FileManager fm = FileManager.getInstance();
        Shape shape = fm.getShape(shapeID);
        for (String arg : args) {
            if (arg.startsWith("vertical=")) {
                int y = Integer.parseInt(arg.substring(9));
                shape.translateVertical(y);
            }
            if (arg.startsWith("horizontal=")) {
                int x = Integer.parseInt(arg.substring(11));
                shape.translateHorizontal(x);
            }
        }
        fm.editShape(shapeID, shape);
    }
}
