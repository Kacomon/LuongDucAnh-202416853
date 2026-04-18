package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.disc.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", 20.00);

        System.out.println("--- Testing Add ---");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        System.out.println("\n--- Testing Remove (Existing Item) ---");
        store.removeDVD(dvd2);

        System.out.println("\n--- Testing Remove (Non-Existing Item) ---");
        store.removeDVD(dvd4);
    }
}