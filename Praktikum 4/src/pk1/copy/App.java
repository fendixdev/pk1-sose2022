package pk1.copy;

import java.io.*;

public class App {
    public static void main(String[] args) {

    }

    public static void copy(File from, File to) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try { //siehe pk1-Teil05 Seite 121
            in = new FileInputStream(from);
            out = new FileOutputStream(to);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
