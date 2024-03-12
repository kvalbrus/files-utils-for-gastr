import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        final var str1 = new ArrayList<>(new BufferedReader(new FileReader("a")).lines().toList());
        final var str2 = new ArrayList<>(new BufferedReader(new FileReader("b")).lines().toList());

        for (final var s2 : str2) {
            str1.remove(s2);
        }

        final var outputFile = new File("c");
        outputFile.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter("c"));

        str1.forEach(it -> {
            try {
                writer.write(it + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        writer.close();
    }
}