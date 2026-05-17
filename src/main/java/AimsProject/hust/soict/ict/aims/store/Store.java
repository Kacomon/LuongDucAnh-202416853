package AimsProject.hust.soict.ict.aims.store;

import java.util.ArrayList;
import AimsProject.hust.soict.ict.aims.media.Media;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;

    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("ERROR: Cannot add null media.");
            return;
        }
        if (itemsInStore.contains(media)) {
            System.out.println("ERROR: Media already exists in the store.");
            return;
        }
        itemsInStore.add(media);
        System.out.println("SUCCESS: " + media.getTitle() + " has been added to the store's inventory.");
    }

    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("ERROR: Cannot remove null media.");
            return;
        }
        if (itemsInStore.remove(media)) {
            System.out.println("SUCCESS: " + media.getTitle() + " has been removed from the store's inventory.");
        } else {
            System.out.println("ERROR: " + media.getTitle() + " was not found in the store's inventory.");
        }
    }

    public Media searchByTitle(String title) {
        if (title == null) {
            return null;
        }
        for (Media media : itemsInStore) {
            if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public Media searchById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media media = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + media.toString());
            }
        }
        System.out.println("***************************************************");
    }
}
