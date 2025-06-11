package View;
import java.util.*;
public class TicketView {
    Scanner scanner = new Scanner(System.in);
    public  void displayMenu(){
        System.out.println("****** Chose an Option ****** ");
        System.out.println("""
                1. Create Ticket\s
                2. Get All Tickets
                3. Get Tickets of Status
                4. Update ticket
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
