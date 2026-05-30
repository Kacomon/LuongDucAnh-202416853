package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95,87,"Roger Allers");
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95,87,"George Lucas");
        cart.addMedia(dvd2);

        System.out.println("\n--- Testing Print Method ---");
        cart.print();


        System.out.println("\n--- Testing Search By ID ---");
        cart.searchById(1);
        cart.searchById(99);

        System.out.println("\n--- Testing Search By Title ---");
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Aladdin");
        cart.searchByTitle("Frozen");
    }
}