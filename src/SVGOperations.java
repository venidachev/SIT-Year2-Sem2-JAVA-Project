import res.R;
import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;
import shapes.Shape;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SVGOperations {

    public SVGOperations() {}

    public List<Shape> parseFile(String path) {
        List<Shape> shapes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
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
            File newFile = new File(path);
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
    public Shape parseShape(String shape) {
        if (shape.startsWith(R.rect)) return new Rectangle(shape);
        if (shape.startsWith(R.circle)) return new Circle(shape);
        if (shape.startsWith(R.line)) return new Line(shape);
        return null;
    }
}
