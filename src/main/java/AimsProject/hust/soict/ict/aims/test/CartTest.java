package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        Book book1 = new Book(2, "Clean Code", "Software", 29.99f);
        book1.addAuthor("Robert C. Martin");
        cart.addMedia(book1);

        CompactDisc cd1 = new CompactDisc(3, "Hybrid Theory", "Rock", "Don Gilmore", 15.0f, "Linkin Park");
        cd1.addTrack(new Track("Papercut", 185));
        cd1.addTrack(new Track("In the End", 216));
        cart.addMedia(cd1);

        System.out.println("\n--- Testing Print Method ---");
        cart.print();

        System.out.println("\n--- Testing Search By ID ---");
        System.out.println(cart.searchById(1));
        System.out.println(cart.searchById(99));

        System.out.println("\n--- Testing Search By Title ---");
        System.out.println(cart.searchByTitle("Star Wars"));
        System.out.println(cart.searchByTitle("In the End"));

        System.out.println("\n--- Testing Sort by Title ---");
        cart.sortByTitle();
        cart.print();
    }
}
