package AimsProject.hust.soict.ict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, director, length);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost, "", 0);
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("Cannot play DVD: " + getTitle());
            return;
        }
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }

    @Override
    public String toString() {
        return "DVD - [" + getTitle() + "] - [" + getCategory() + "] - ["
                + getDirector() + "] - [" + getLength() + "]: [" + getCost() + "] $";
    }
}
