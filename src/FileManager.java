import res.R;
import shapes.Shape;

import java.util.List;

public class FileManager {
    private static FileManager instance = null;
    private String currentFile = null;
    private List<Shape> shapes = null;

    private FileManager() {}

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public void openFile(String fileName) {
        if (currentFile != null) {
            System.out.println(R.failOpen + currentFile);
            return;
        }
        SVGOperations svg = new SVGOperations();

        shapes = svg.parseFile(fileName);
        currentFile = fileName;
        System.out.println(R.successOpen + currentFile);
    }

    public void closeFile() {
        if (currentFile == null) {
            System.out.println(R.errorNoFileOpen);
            return;
        }
        System.out.println(R.successClose + currentFile);
        currentFile = null;
    }

    public String getCurrentFile() {
        return currentFile;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
