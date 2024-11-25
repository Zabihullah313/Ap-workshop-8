import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Notebook {
    private Map<String, Note> notes = new HashMap<>();
    private final String saveFilePath = "notebook_data.ser";


    public Notebook() {
        loadNotes();
    }

    public void addNote(String title, String content) {
        if (notes.containsKey(title)) {
            System.out.println("A note with this title already exists.");
            return;
        }
        notes.put(title, new Note(title, content));
        saveNotes();
        System.out.println("Note added successfully!");
    }

    public void removeNote(String title) {
        if (!notes.containsKey(title)) {
            System.out.println("No note found with the given title.");
            return;
        }
        notes.remove(title);
        saveNotes();
        System.out.println("Note removed successfully!");
    }

    public void listNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }
        System.out.println("Available Notes:");
        for (String title : notes.keySet()) {
            System.out.println("- " + title);
        }
    }

    public void viewNote(String title) {
        if (!notes.containsKey(title)) {
            System.out.println("No note found with the given title.");
            return;
        }
        System.out.println(notes.get(title));
    }


    private void saveNotes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFilePath))) {
            oos.writeObject(notes);
        } catch (IOException e) {
            System.out.println("Error saving notes: " + e.getMessage());
        }
    }

    private void loadNotes() {
        File file = new File(saveFilePath);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            notes = (Map<String, Note>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading notes: " + e.getMessage());
        }
    }


    public void exportNote(String title) {
        if (!notes.containsKey(title)) {
            System.out.println("No note found with the given title.");
            return;
        }
        Note note = notes.get(title);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("export/" + title + ".txt"))) {
            writer.write(note.toString());
            System.out.println("Note exported successfully!");
        } catch (IOException e) {
            System.out.println("Error exporting note: " + e.getMessage());
        }
    }


}