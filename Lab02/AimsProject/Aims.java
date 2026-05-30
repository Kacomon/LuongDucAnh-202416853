public class Aims {
    public static void main(String[] args) {
        // §10 – Create a cart and populate with DVDs
        Cart anOrder = new Cart();

        // Constructor: (title, category, director, length, cost)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        // Constructor: (title, category, cost)
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total Cost is: " + anOrder.totalCost() + " $");

        // §11 – Remove a DVD and check total again
        System.out.println("\n--- Removing Star Wars ---");
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost after removal: " + anOrder.totalCost() + " $");

        // Test removing a DVD not in cart
        System.out.println("\n--- Trying to remove Star Wars again ---");
        anOrder.removeDigitalVideoDisc(dvd2);
    }
}
