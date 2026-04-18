package AimsProject.src;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("\n Testing Assigned IDs");
        System.out.println(dvd1.getTitle() + " ID: " + dvd1.getId());
        System.out.println(dvd2.getTitle() + " ID: " + dvd2.getId());
        System.out.println(dvd3.getTitle() + " ID: " + dvd3.getId());

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost after removing Star Wars is: ");
        System.out.println(anOrder.totalCost());
    }
}