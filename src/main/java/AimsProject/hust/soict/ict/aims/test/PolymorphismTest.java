package AimsProject.hust.soict.ict.aims.test;

import java.util.ArrayList;
import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Media;
import AimsProject.hust.soict.ict.aims.media.Track;

/**
 * Exercise 11: Polymorphism with toString() method
 * 
 * This test class demonstrates polymorphism at the behavior level.
 * When calling toString() method on Media objects stored in an ArrayList,
 * the appropriate toString() implementation of each subclass is called
 * based on the actual object type at runtime, not the reference type.
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        System.out.println("=== Exercise 11: Polymorphism with toString() ===\n");
        
        // Create an ArrayList of Media (reference type is Media)
        ArrayList<Media> medias = new ArrayList<>();
        
        // Create instances of different media types
        Book book = new Book(1, "Clean Code", "Software", 29.99f);
        book.addAuthor("Robert C. Martin");
        
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        
        CompactDisc cd = new CompactDisc(3, "Thriller", "Pop", "Quincy Jones", 18.50f, "Michael Jackson");
        cd.addTrack(new Track("Thriller", 357));
        cd.addTrack(new Track("Beat It", 258));
        
        // Add all media to the ArrayList
        medias.add(book);
        medias.add(dvd);
        medias.add(cd);
        
        // Polymorphic behavior: iterate and print using toString()
        System.out.println("Iterating through ArrayList<Media> and calling toString():");
        System.out.println("(Notice how each object's specific toString() is called)\n");
        
        for (Media media : medias) {
            System.out.println(media.toString());
            System.out.println();
        }
        
        System.out.println("=== Explanation ===");
        System.out.println("1. The reference type is Media (superclass)");
        System.out.println("2. The actual object types are Book, DigitalVideoDisc, CompactDisc (subclasses)");
        System.out.println("3. When toString() is called on each media object,");
        System.out.println("   the JVM uses dynamic dispatch (runtime polymorphism)");
        System.out.println("   to call the appropriate toString() method for each actual type.");
        System.out.println("4. This is the power of polymorphism:");
        System.out.println("   - Same method call (toString())");
        System.out.println("   - Different behavior depending on the actual object type");
    }
}
