public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Getters only (no setters - no use case requires modifying DVD after creation)
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }

    // §8 Constructor 1: by title only
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // §8 Constructor 2: by title, category, cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // §8 Constructor 3: by title, category, director, cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // §8 Constructor 4: all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "DVD - [" + title + "] - [" + category + "] - [" + director + "] - [" + length + "]: [" + cost + "] $";
    }
}
