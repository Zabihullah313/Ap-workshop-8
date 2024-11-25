import java.time.LocalDate;

class Note {
    private String title;
    private String content;
    private LocalDate creationDate;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.creationDate = LocalDate.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDate: " + creationDate + "\nContent:\n" + content;
    }
}