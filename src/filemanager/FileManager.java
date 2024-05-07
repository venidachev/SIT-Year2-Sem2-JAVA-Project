package filemanager;

import res.R;
import shapes.Shape;
import svg.SVGOperations;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    private static FileManager instance = null;
    private Path path = null;
    private List<Shape> shapes;

    private String startOfFile;
    private String endOfFile = "</svg>";

    private FileManager() {}

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public static int openFileCheck() {
        FileManager fm = FileManager.getInstance();
        if (fm.getPath() == null) {
            System.out.println(R.errorNoFileOpen);
            return 1;
        }
        return 0;
    }

    public Path getPath() {
        return path;
    }

    public void openFile(String filePath) {
        if (path != null) {
            System.out.println(R.failOpen + path.getFileName().toString());
            return;
        }

        SVGOperations svg = new SVGOperations();
        path = Paths.get(filePath);

        startOfFile = svg.parseStartOfFile(path);
        shapes = svg.parseFile(path);

        System.out.println(R.successOpen + path.getFileName().toString());
    }

    public void closeFile() {
        if (path == null) {
            System.out.println(R.errorNoFileOpen);
            return;
        }
        System.out.println(R.successClose + path);
        path = null;
    }

    public void saveFile() {
        if (path == null) {
            System.out.println(R.errorNoFileOpen);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(startOfFile);
        for (Shape shape: shapes) {
            sb.append(shape.toString()).append("\n");
        }
        sb.append(endOfFile);
        try (FileWriter writer = new FileWriter(path.toFile())) {
            writer.write(sb.toString());
            System.out.println(R.successSave + path.getFileName().toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveasFile(String filePath) {
        Path tempPath = path;
        path = Paths.get(filePath);
        saveFile();
        path = tempPath;
    }

    public String getFileName() {
        return path.getFileName().toString();
    }

    public Shape getShape(int id) {
        return shapes.get(--id);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(int id) {
        String shape = shapes.get(--id).getName();
        shapes.remove(id++);
        System.out.println(R.eraseSuccess + shape + " (" + id + ")");
    }

    public void editShape(int id, Shape shape) {
        shapes.set(--id, shape);
    }
}
