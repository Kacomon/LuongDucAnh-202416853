package AimsProject.hust.soict.ict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost, director, length);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(0, title, category, cost, "", 0);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(0, title, category, cost, director, length);
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
        return "DVD - [" + getTitle() + "] - [" + getCategory() + "] - [" + getDirector() + "] - [" + getLength() + "]: [" + getCost() + "] $";
    }
}
