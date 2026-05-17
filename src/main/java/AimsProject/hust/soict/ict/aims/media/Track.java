package AimsProject.hust.soict.ict.aims.media;

public class Track implements Playable {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;
        if (title == null) {
            return other.title == null && length == other.length;
        }
        return title.equalsIgnoreCase(other.title) && length == other.length;
    }

    @Override
    public int hashCode() {
        int result = title == null ? 0 : title.toLowerCase().hashCode();
        result = 31 * result + Integer.hashCode(length);
        return result;
    }

    @Override
    public void play() {
        if (length <= 0) {
            System.out.println("Cannot play track: " + title);
            return;
        }
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
    }

    @Override
    public String toString() {
        return "Track: [" + title + "] - [" + length + "]";
    }
}
