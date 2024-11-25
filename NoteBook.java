import java.util.HashMap;
import java.util.Map;

    class Notebook {
        private Map<String, Note> notes = new HashMap<>();
        private final String saveFilePath = "notebook_data.ser";


        public Notebook() {
            loadNotes();
        }


