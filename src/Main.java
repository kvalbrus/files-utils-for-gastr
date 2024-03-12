import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        compareFiles("b", "a", "c");
    }

    public static void compareFiles(String file1Path, String file2Path, String outputPath) {
        Set<String> file1Lines = readFileLines(file1Path);
        Set<String> file2Lines = readFileLines(file2Path);
        Set<String> uniqueLines = new HashSet<>(file1Lines);
        uniqueLines.removeAll(file2Lines);
        writeToFile(outputPath, uniqueLines);
    }

    private static Set<String> readFileLines(String filePath) {
        Set<String> lines = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static void writeToFile(String filePath, Set<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
