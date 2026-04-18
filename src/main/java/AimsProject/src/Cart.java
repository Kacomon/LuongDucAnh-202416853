package AimsProject.src;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public Cart(DigitalVideoDisc... items){
        if(items.length > MAX_NUMBERS_ORDERED){
            throw new IllegalArgumentException("Maximum number of items is " + MAX_NUMBERS_ORDERED);
        }
        for(DigitalVideoDisc item : items){
            this.itemsOrdered[qtyOrdered] = item;
            this.qtyOrdered++;
        }
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

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

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Match found by Title: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for Title: " + title);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc item){
        if(qtyOrdered >= MAX_NUMBERS_ORDERED){
            System.err.println("Cart is full!");
            return;
        }
        itemsOrdered[qtyOrdered] = item;
        qtyOrdered++;
        System.out.println("The disc has been added to the cart!");

        if(qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("Cart is full!");
        }else if(qtyOrdered == MAX_NUMBERS_ORDERED - 1){
            System.out.println("Cart is almost full!");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean found = false;
        for(int i =0; i< itemsOrdered.length; i++){
            if(itemsOrdered[i].equals(disc)){
                found = true;
                for(int j = i; j < qtyOrdered - 1; j++){
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed from the cart!");
                break;
            }
        }
        if(!found){
            System.out.println("The disc not found!");
        }
    }

    public double totalCost(){
        double total = 0;
        for(int i = 0; i < qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

}
