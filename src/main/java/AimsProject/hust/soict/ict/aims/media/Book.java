package AimsProject.hust.soict.ict.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private int contentLength;
    private final ArrayList<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
        this.contentLength = 0;
    }

    public Book(String title, String category, float cost, int contentLength) {
        super(title, category, cost);
        this.contentLength = contentLength;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
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

    @Override
    public String toString() {
        return "Book - [" + getTitle() + "] - [" + getCategory() + "] - authors=" + authors
                + " - content length=" + contentLength + " - [" + getCost() + "] $";
    }
}
