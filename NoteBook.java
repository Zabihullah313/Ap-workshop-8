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



