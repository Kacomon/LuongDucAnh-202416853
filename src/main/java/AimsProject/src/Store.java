package AimsProject.src;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;

    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("SUCCESS: " + dvd.getTitle() + " has been added to the store's inventory.");
        } else {
            System.out.println("ERROR: The store's inventory is full. Cannot add more items.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].equals(dvd)) {
                found = true;
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("SUCCESS: " + dvd.getTitle() + " has been removed from the store's inventory.");
                break;
            }
        }
        if (!found) {
            System.out.println("ERROR: " + dvd.getTitle() + " was not found in the store's inventory.");
        }
    }
}