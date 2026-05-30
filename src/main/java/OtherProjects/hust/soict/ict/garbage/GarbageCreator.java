package OtherProjects.hust.soict.ict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Demonstrates the "garbage" problem when using + to build strings in a loop.
 * Each += creates a new String object, flooding the heap and triggering GC.
 */
public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe";
        byte[] inputBytes;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            // Fallback: simulate with a large byte array if file not found
            System.err.println("File not found, using simulated data.");
            inputBytes = new byte[100000];
        }

        // BAD: using + creates a new String object on every iteration — lots of garbage
        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;  // GARBAGE: old string discarded each iteration
        }
        long endTime = System.currentTimeMillis();
        System.out.println("GarbageCreator (+ operator) time: " + (endTime - startTime) + " ms");
    }
}
