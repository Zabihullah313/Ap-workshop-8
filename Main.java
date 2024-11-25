import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Personal Notebook ---");
            System.out.println("1. Add Note");
            System.out.println("2. Remove Note");
            System.out.println("3. List Notes");
            System.out.println("4. View Note");
            System.out.println("5. Export Note");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter note title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter note content (end with an empty line):");
                    StringBuilder content = new StringBuilder();
                    while (true) {
                        String line = scanner.nextLine();
                        if (line.isEmpty()) break;
                        content.append(line).append("\n");
                    }
                    notebook.addNote(title, content.toString().trim());
                    break;


                case 2:
                    System.out.print("Enter note title to remove: ");
                    notebook.removeNote(scanner.nextLine());
                    break;

                case 3:
                    notebook.listNotes();
                    break;

                case 4:
                    System.out.print("Enter note title to view: ");
                    notebook.viewNote(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter note title to export: ");
                    notebook.exportNote(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");

            }
        }
    }
}