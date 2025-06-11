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
    public String userInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public void showTicketCreated(int ticketId) {
        System.out.println("Ticket created successfully! ID: " + ticketId);
    }
    public static void main (String [ ]args){
        TicketView see = new TicketView();
        see.displayMenu();
    }
}
