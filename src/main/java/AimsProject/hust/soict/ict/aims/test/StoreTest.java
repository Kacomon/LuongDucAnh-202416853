package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Track;
import AimsProject.hust.soict.ict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        Book book = new Book("The War of Art", "Self-Help", 12.99f, 35000);
        book.addAuthor("Steven Pressfield");

        DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Quincy Jones", 18.50f, "Michael Jackson");
        cd.addTrack(new Track("Thriller", 357));

        store.addMedia(book);
        store.addMedia(dvd);
        store.addMedia(cd);
        store.print();

        System.out.println("\n-- Search by title: 'Star Wars' --");
        System.out.println(store.searchByTitle("Star Wars"));

        System.out.println("\n-- Remove book --");
        store.removeMedia(book);
        store.print();
    }
}
