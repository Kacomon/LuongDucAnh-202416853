package AimsProject.hust.soict.ict.aims.test;

import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 18.99, 87,"Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95, 87, "Goerge Lucas");

        System.out.println("--- Testing Add ---");
        store.addMedia(dvd1);
        store.addMedia(dvd2);

        System.out.println("\n--- Testing Remove ---");
        store.removeMedia(dvd2);

    }
}