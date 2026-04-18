package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99);
        cart.addDigitalVideoDisc(dvd3);

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