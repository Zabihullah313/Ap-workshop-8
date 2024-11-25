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





