package Lab02.AimsProject.src;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;


    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, double cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public double getCost(){
        return cost;
    }
}
