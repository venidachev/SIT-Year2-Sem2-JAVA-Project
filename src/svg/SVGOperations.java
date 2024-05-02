package svg;

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
}
