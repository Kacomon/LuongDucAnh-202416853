package AimsProject.hust.soict.ict.aims;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.exception.PlayerException;
import AimsProject.hust.soict.ict.aims.media.*;
import AimsProject.hust.soict.ict.aims.screen.StoreScreen;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        // Sample data
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", "Sci-Fi", 22.50, 148, "Christopher Nolan");
        CompactDisc cd1 = new CompactDisc("Album Danh Doi", "Music", 20.5, "Obito", "Obito");
        CompactDisc cd2 = new CompactDisc("Thriller", "Music", 18.0, "Quincy Jones", "Michael Jackson");
        Book book1 = new Book("Effective Java", "Programming", 30.00, "Joshua Bloch");
        Book book2 = new Book("Object Oriented Programming", "Programming", 15.6, "Nguyen Thu Trang");
        Book book3 = new Book("Clean Code", "Programming", 25.0, "Robert C. Martin");

        Track track1 = new Track("Danh Doi", 23);
        Track track2 = new Track("Danh Nhau", 20);
        Track track3 = new Track("Billie Jean", 294);
        Track track4 = new Track("Beat It", 258);

        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd2.addTrack(track3);
        cd2.addTrack(track4);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        // Test try-catch for play()
        DigitalVideoDisc badDvd = new DigitalVideoDisc("Bad DVD");
        try {
            badDvd.play();
        } catch (PlayerException e) {
            System.err.println("Caught PlayerException: " + e.getMessage());
            e.printStackTrace();
        }

        // Launch GUI
        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }
}
