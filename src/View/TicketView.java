package View;
import java.util.*;
public class TicketView {
    Scanner scanner = new Scanner(System.in);
    public  void displayMenu(){
        System.out.println("****** Chose an Option ****** ");
        System.out.println("""
                1. Create Ticket\s
                2. Get All Tickets
                3. Search for Ticket 
                4. Modify Tickets
                5. Exist
                """);
    }

    public void updateDeleteMenu(){
        System.out.println("""
                1. Update Ticket
                2. Delete Ticket
                """);
    }
    public String userInput(String label) {
        System.out.print(label + " : ");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

}
