package AimsProject.hust.soict.ict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, double cost, String director, String artist) {
        super(title, category, cost,  director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    @Override
    public int getLength() {
        int sum = 0;
        for (Track t : tracks) {
            sum += t.getLength();
        }
        return sum;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD Artist: " + this.artist);
        System.out.println("CD Total length: " + this.getLength());
        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + artist + " - " + getLength() + ":00 - " + getCost() + "$";
    }
}