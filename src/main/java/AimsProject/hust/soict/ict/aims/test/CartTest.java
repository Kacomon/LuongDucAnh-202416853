package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99);

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
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

        System.out.println("\n--- Testing addDigitalVideoDisc(dvd1, dvd2) overload ---");
        Cart cart2 = new Cart();
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", 20.00);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Moana", "Animation", 17.50);
        cart2.addDigitalVideoDisc(dvd4, dvd5);
        cart2.print();

        System.out.println("\n--- Testing addDigitalVideoDisc(array) overload ---");
        Cart cart3 = new Cart();
        DigitalVideoDisc[] dvdArray = {
            new DigitalVideoDisc("Coco", "Animation", 15.00),
            new DigitalVideoDisc("Up", "Animation", 14.00)
        };
        cart3.addDigitalVideoDisc(dvdArray);
        cart3.print();

        System.out.println("\n--- Testing Remove ---");
        cart.removeDigitalVideoDisc(dvd2);
        cart.print();
    }
}
