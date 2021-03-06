package ee.taltech.iti0202.tk1.art;

public class Painting {
    String author;
    String title;

    /**
     *
     * @param name name.
     */
    public Painting(String name) {
        this.title = name;
    }

    /**
     *
     * @param name name.
     * @param author author.
     */
    public Painting(String name, String author) {
        this.title = name;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    /**
     *
     * @param author author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @param title title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return string.
     */
    public String toString() {
        if (this.author != null && this.title != null) {
            return "This is a painting named " + this.title + " and made by " + this.author + ".";
        } else {
            return "This is a painting named " + this.title + " and made by an unknown artist.";
        }
    }
}
