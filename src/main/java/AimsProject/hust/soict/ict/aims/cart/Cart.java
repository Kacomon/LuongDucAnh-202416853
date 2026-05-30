package AimsProject.hust.soict.ict.aims.cart;

import AimsProject.hust.soict.ict.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public Cart() {}

    public Cart(DigitalVideoDisc... items) {
        for (DigitalVideoDisc item : items) {
            addDigitalVideoDisc(item);
        }
    }

    // §2.1 – overload: single DVD
    public void addDigitalVideoDisc(DigitalVideoDisc item) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full! Cannot add more items.");
            return;
        }
        itemsOrdered[qtyOrdered] = item;
        qtyOrdered++;
        System.out.println("The disc has been added to the cart!");
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("Cart is full!");
        } else if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
            System.out.println("Cart is almost full!");
        }
    }

    // §2.1 – overload: array / varargs
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full! Cannot add more discs.");
                break;
            }
            addDigitalVideoDisc(disc);
        }
    }

    // §2.2 – overload: two DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed from the cart!");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the cart!");
        }
    }

    // §6 – print cart
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // §6 – search by ID
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Match found by ID: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    // §6 – search by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Match found by Title: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }

    public double totalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
