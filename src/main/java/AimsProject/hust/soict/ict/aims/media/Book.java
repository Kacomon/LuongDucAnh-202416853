package AimsProject.hust.soict.ict.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private final ArrayList<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (authorName == null || authorName.isEmpty()) {
            System.out.println("Cannot add empty author name.");
            return;
        }
        if (authors.contains(authorName)) {
            System.out.println("Author already exists: " + authorName);
            return;
        }
        authors.add(authorName);
        System.out.println("Author added: " + authorName);
    }

    public void removeAuthor(String authorName) {
        if (authorName == null || authorName.isEmpty()) {
            System.out.println("Cannot remove empty author name.");
            return;
        }
        if (authors.remove(authorName)) {
            System.out.println("Author removed: " + authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }

    public int getLength() {
        if (getTitle() == null || getTitle().trim().isEmpty()) {
            return 0;
        }
        return getTitle().trim().split("\\s+").length;
    }

    @Override
    public String toString() {
        return "Book - [" + getTitle() + "] - [" + getCategory() + "] - authors=" + authors + " - content length=" + getLength() + " - [" + getCost() + "] $";
    }
}
