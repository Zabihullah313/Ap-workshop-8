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
        }
}
