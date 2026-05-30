package OtherProjects.hust.soict.ict.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r;
        long start;
        String s;

        // Method 1: String + operator (slowest, creates many garbage objects)
        r = new Random(123);
        start = System.currentTimeMillis();
        s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("String (+) time: " + (System.currentTimeMillis() - start) + " ms");

        // Method 2: StringBuilder (fastest, non-thread-safe)
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("StringBuilder time: " + (System.currentTimeMillis() - start) + " ms");

        // Method 3: StringBuffer (thread-safe, slightly slower than StringBuilder)
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbf.append(r.nextInt(2));
        }
        s = sbf.toString();
        System.out.println("StringBuffer time: " + (System.currentTimeMillis() - start) + " ms");
    }
}
