package AimsProject.hust.soict.ict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import AimsProject.hust.soict.ict.aims.media.Media;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add null media to the cart.");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("The media is already in the cart!");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("The media has been added to the cart!");
    }

    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot remove null media from the cart.");
            return;
        }
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed from the cart!");
        } else {
            System.out.println("The media not found!");
        }
    }

    public void print() {
        System.out.println("***********************CART***********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
            }
            System.out.println("Total cost: " + totalCost() + " $");
        }
        System.out.println("***************************************************");
    }

    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public Media searchByTitle(String title) {
        if (title == null) {
            return null;
        }
        for (Media media : itemsOrdered) {
            if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public double totalCost() {
        double total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title then cost.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost then title.");
    }

    public void clear() {
        itemsOrdered.clear();
    }
}
