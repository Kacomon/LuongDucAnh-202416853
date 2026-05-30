package AimsProject.hust.soict.ict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private final String artist;
    private final ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String director, float cost, String artist) {
        super(title, category, cost, director, 0);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot add null track.");
            return;
        }
        if (tracks.contains(track)) {
            System.out.println("Track already exists: " + track.getTitle());
            return;
        }
        tracks.add(track);
        System.out.println("Track added: " + track.getTitle());
    }

    public void removeTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot remove null track.");
            return;
        }
        if (tracks.remove(track)) {
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    @Override
    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("Cannot play CD: " + getTitle());
            return;
        }
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - [").append(getTitle()).append("] - [").append(getCategory())
          .append("] - [").append(artist).append("] - [").append(getDirector())
          .append("] - [").append(getLength()).append("] : [").append(getCost()).append("] $");
        if (!tracks.isEmpty()) {
            sb.append("\nTracks:");
            for (Track t : tracks) {
                sb.append("\n  ").append(t.toString());
            }
        }
        return sb.toString();
    }
}
