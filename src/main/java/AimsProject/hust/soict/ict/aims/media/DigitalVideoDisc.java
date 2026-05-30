package AimsProject.hust.soict.ict.aims.media;

import AimsProject.hust.soict.ict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String name) {
        super(name);
    }

    public DigitalVideoDisc(String title, String category, double cost, int length, String director) {
        super(title, category, cost, length, director);
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory()
                + " - " + this.getDirector() + " - " + this.getLength()
                + " - " + this.getCost() + " $";
    }

    public boolean isMatch(String title) {
        if (this.getTitle() == null || title == null) return false;
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
}
