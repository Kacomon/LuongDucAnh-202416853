package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Book book = new Book("Clean Code", "Software", 29.99f, 90000);
        book.addAuthor("Robert C. Martin");

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        CompactDisc cd = new CompactDisc("Hybrid Theory", "Rock", "Don Gilmore", 15.00f, "Linkin Park");
        cd.addTrack(new Track("In the End", 216));
        cd.addTrack(new Track("Papercut", 185));

        cart.addMedia(book);
        cart.addMedia(dvd);
        cart.addMedia(cd);
        cart.print();

        System.out.println("\n-- Sort by title --");
        cart.sortByTitle();
        cart.print();

        System.out.println("\n-- Sort by cost --");
        cart.sortByCost();
        cart.print();

        System.out.println("\n-- Remove DVD --");
        cart.removeMedia(dvd);
        cart.print();
    }
}
