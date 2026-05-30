package AimsProject.hust.soict.ict.aims.media;

import AimsProject.hust.soict.ict.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() throws PlayerException {
        if (length > 0) {
            System.out.println("Playing Track: " + this.title);
            System.out.println("Track length: " + this.length);
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Track)) return false;
        Track other = (Track) o;
        return this.title.equals(other.title) && this.length == other.length;
    }
}
