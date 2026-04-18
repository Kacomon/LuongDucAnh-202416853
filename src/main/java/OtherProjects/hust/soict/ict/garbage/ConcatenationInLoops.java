package OtherProjects.hust.soict.ict.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("String (+) time: " + (System.currentTimeMillis() - start) + " ms"); // Prints roughly 4500 [cite: 1085]

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("StringBuilder time: " + (System.currentTimeMillis() - start) + " ms"); // Prints roughly 5 [cite: 1113]

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sBuffer.append(r.nextInt(2));
        }
        s = sBuffer.toString();
        System.out.println("StringBuffer time: " + (System.currentTimeMillis() - start) + " ms");
    }
}