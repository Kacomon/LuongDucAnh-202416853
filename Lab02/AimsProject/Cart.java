public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // §9 – add DVD to cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full!");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added to the cart!");
        // Warn when cart reaches max capacity
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full!");
        } else if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
            System.out.println("The cart is almost full!");
        }
    }

    // §11 – remove DVD from cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                // Shift remaining elements left
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // clear last slot
                qtyOrdered--;
                System.out.println("The disc has been removed from the cart!");
                return;
            }
        }
        if (!found) {
            System.out.println("The disc is not found in the cart!");
        }
    }

    // §9 – total cost
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
