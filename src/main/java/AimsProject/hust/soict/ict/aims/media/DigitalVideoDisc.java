package AimsProject.hust.soict.ict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String name) {
        super(name);
    }

    public DigitalVideoDisc(String title, String category, double cost, int length, String director) {
        super(title, category, cost, length, director);
    }

    @Override
    public void play() {
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("Cannot play DVD: Length is 0 or invalid.");
        }
    }


    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() +" - " + this.getCost() + " $";
    }

    public boolean isMatch(String title) {
        if (this.getTitle() == null || title == null) {
            return false;
        }
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
}