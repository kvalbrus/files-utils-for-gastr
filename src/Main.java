import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        final var str1 = new ArrayList<>(new BufferedReader(new FileReader("a")).lines().toList());
        final var str2 = new ArrayList<>(new BufferedReader(new FileReader("b")).lines().toList());

        System.out.println("Перебирание:");

        int i = 0;
//        int h = str2.size() / 100;
        for (final var s2 : str2) {
            if (i % 100000 == 0) {
                System.out.println(i + "/" + str2.size());
            }

            i++;

            str1.remove(s2);
        }

        final var outputFile = new File("c");
        outputFile.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter("c"));

        System.out.println("Создание файла:");

        int j = 0;
//        h = str1.size() / 100;
        for (final var s1 : str1) {
            try {
                if (j % 100000 == 0) {
                    System.out.println(j + "/" + str1.size());
                }

                j++;

                writer.write(s1 + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        writer.close();
    }
}