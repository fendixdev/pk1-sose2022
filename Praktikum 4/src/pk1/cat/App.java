package pk1.cat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class App {
    public static void main(String[] args) {
        cat();
    }

    public static void cat() {
        try (RandomAccessFile f = new RandomAccessFile("/Users/max/Documents/GitHub/pk1-sose2022/Praktikum 4/src/pk1/cat/text.txt", "r")) {
            System.out.println(f.readLine());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
