package AimsProject.hust.soict.ict.aims.test;

import java.util.ArrayList;
import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Media;
import AimsProject.hust.soict.ict.aims.media.Track;

/**
 * Exercise 11: Polymorphism with toString() method
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        System.out.println("=== Exercise 11: Polymorphism with toString() ===\n");

        ArrayList<Media> medias = new ArrayList<>();

        Book book = new Book("Clean Code", "Software", 29.99f, 90000);
        book.addAuthor("Robert C. Martin");

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Quincy Jones", 18.50f, "Michael Jackson");
        cd.addTrack(new Track("Thriller", 357));
        cd.addTrack(new Track("Beat It", 258));

        medias.add(book);
        medias.add(dvd);
        medias.add(cd);

        System.out.println("Iterating through ArrayList<Media> and calling toString():\n");
        for (Media m : medias) {
            System.out.println(m.toString());
            System.out.println();
        }

        System.out.println("=== Explanation ===");
        System.out.println("- Reference type is Media (superclass)");
        System.out.println("- Actual types: Book, DigitalVideoDisc, CompactDisc (subclasses)");
        System.out.println("- JVM uses dynamic dispatch: calls the toString() of the actual runtime type");
        System.out.println("- Same method call -> different behavior = Polymorphism");
    }
}
