package AimsProject.hust.soict.ict.aims;

import java.util.Scanner;

import AimsProject.hust.soict.ict.aims.cart.Cart;
import AimsProject.hust.soict.ict.aims.media.Book;
import AimsProject.hust.soict.ict.aims.media.CompactDisc;
import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.media.Media;
import AimsProject.hust.soict.ict.aims.media.Playable;
import AimsProject.hust.soict.ict.aims.media.Track;
import AimsProject.hust.soict.ict.aims.store.Store;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        initStore();
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    showStoreMenu();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    showCartMenu();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void showStoreMenu() {
        boolean back = false;
        while (!back) {
            store.print();
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    showMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMediaInStore();
                    break;
                case 4:
                    showCartMenu();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void showMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found: " + title);
            return;
        }
        System.out.println(media.toString());
        showDetailsMenu(media);
    }

    public static void showDetailsMenu(Media media) {
        boolean back = false;
        while (!back) {
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter media title to add: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found: " + title);
            return;
        }
        cart.addMedia(media);
    }

    public static void playMediaInStore() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found: " + title);
            return;
        }
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void showCartMenu() {
        boolean back = false;
        while (!back) {
            cart.print();
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void filterCart() {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                System.out.print("Enter media id: ");
                int id = getIntInput();
                Media foundById = cart.searchById(id);
                if (foundById != null) {
                    System.out.println(foundById.toString());
                } else {
                    System.out.println("No media found with id " + id);
                }
                break;
            case 2:
                System.out.print("Enter media title: ");
                String title = scanner.nextLine().trim();
                Media foundByTitle = cart.searchByTitle(title);
                if (foundByTitle != null) {
                    System.out.println(foundByTitle.toString());
                } else {
                    System.out.println("No media found with title " + title);
                }
                break;
            default:
                System.out.println("Please enter a valid option.");
        }
    }

    public static void sortCart() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
            default:
                System.out.println("Please enter a valid option.");
        }
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine().trim();
        Media media = cart.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found in cart: " + title);
            return;
        }
        cart.removeMedia(media);
    }

    public static void playMediaInCart() {
        System.out.print("Enter media title to play from cart: ");
        String title = scanner.nextLine().trim();
        Media media = cart.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found in cart: " + title);
            return;
        }
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void placeOrder() {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return;
        }
        System.out.println("Order is created. Total cost: " + cart.totalCost() + " $");
        cart.clear();
    }

    public static void updateStore() {
        System.out.println("Update store is not implemented in this sample application.");
        System.out.println("Use View store or AIMS source code to modify store contents.");
    }

    private static int getIntInput() {
        int value = -1;
        try {
            String line = scanner.nextLine().trim();
            value = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
        }
        return value;
    }

    private static void initStore() {
        Book book1 = new Book(1, "The War of Art", "Self-Help", 12.99f);
        book1.addAuthor("Steven Pressfield");
        Book book2 = new Book(2, "Clean Code", "Software", 29.99f);
        book2.addAuthor("Robert C. Martin");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(3, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(4, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        CompactDisc cd1 = new CompactDisc(5, "Hybrid Theory", "Rock", "Don Gilmore", 15.00f, "Linkin Park");
        cd1.addTrack(new Track("Papercut", 185));
        cd1.addTrack(new Track("One Step Closer", 156));
        cd1.addTrack(new Track("In the End", 216));

        CompactDisc cd2 = new CompactDisc(6, "Thriller", "Pop", "Quincy Jones", 18.50f, "Michael Jackson");
        cd2.addTrack(new Track("Thriller", 357));
        cd2.addTrack(new Track("Beat It", 258));

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(cd1);
        store.addMedia(cd2);
    }
}
