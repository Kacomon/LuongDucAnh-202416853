package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Track;
import AimsProject.hust.soict.ict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book1 = new Book(3, "Clean Code", "Software", 29.99f);
        book1.addAuthor("Robert C. Martin");
        CompactDisc cd1 = new CompactDisc(4, "Hybrid Theory", "Rock", "Don Gilmore", 15.00f, "Linkin Park");
        cd1.addTrack(new Track("Papercut", 185));

        System.out.println("--- Testing Add ---");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);

        System.out.println("\n--- Testing Remove (Existing Item) ---");
        store.removeMedia(dvd2);

        System.out.println("\n--- Testing Remove (Non-Existing Item) ---");
        store.removeMedia(new DigitalVideoDisc(99, "Not In Store", "Unknown", "Unknown", 100, 0.0f));
    }
}
