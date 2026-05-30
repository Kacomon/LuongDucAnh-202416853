package AimsProject.hust.soict.ict.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private int contentLength;

    public Book(String title, String category, String contentLength,double cost) {
        super(title, category, cost);

    }

    public Book(String title, String category,double cost,String... names){
        super(title,category,cost);
        for(String name : names){
            this.addAuthor(name);
        }
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists: " + authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }

    @Override
    public String toString() {
        String info = "Book - " + getTitle() + " - " + getCategory() + " - " + getCost() + "$ - ";

        if (authors.isEmpty()) {
            return info + "Unknown Author";
        }

        // Joins the list elements with ", "
        return info + String.join(", ", authors);
    }
}