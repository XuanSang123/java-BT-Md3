package BaiTapXVIII.ioFile.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile<T> {
    public static final String STUDENT_PATH = "src/session18/test/ioeFile/data/student.txt";

    public List<T> readFromFile(String path) {
        List<T> list = new ArrayList<T>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            if (path == null) {
                throw new IllegalArgumentException("File path cannot be null.");
            }

            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + path);
            }

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            if (e instanceof EOFException) {
                System.out.println("End of file reached unexpectedly. File may be corrupted.");
            } else {
                e.printStackTrace();
            }
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Error closing streams: " + e.getMessage());
            }
        }
        return list;
    }

    public void writeToFile(String path, List<T> list) {
        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (IOException e) {
//            System.err.println("eeee");
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
