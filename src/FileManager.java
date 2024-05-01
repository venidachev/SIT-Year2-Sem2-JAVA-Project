import res.R;

public class FileManager {
    private static FileManager instance = null;
    private String currentFile = null;

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
        currentFile = fileName;
        System.out.println(R.successOpen + currentFile);
    }

    public void closeFile() {
        if (currentFile == null) {
            System.out.println(R.failClose);
            return;
        }
        System.out.println(R.successClose + currentFile);
        currentFile = null;
    }
}
