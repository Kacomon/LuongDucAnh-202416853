package AimsProject.hust.soict.ict.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc() {
        super();
    }

    public Disc(String title){
        super(title);
    }

    public Disc(String title, String category,double cost, String director) {
        super(title,category,cost);
        this.director=director;
    }

    public Disc(String title, String category, double cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public void setDirector(String director) {
        this.director = director;
    }

}