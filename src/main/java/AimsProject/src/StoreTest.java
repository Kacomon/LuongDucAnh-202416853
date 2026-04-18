package AimsProject.src;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", 20.00f);

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