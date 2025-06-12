package View;
import java.util.*;
public class TicketView {
    Scanner scanner = new Scanner(System.in);
    //main menu display .
    public  void displayMenu(){
        System.out.println("****** Chose an Option ****** ");
        System.out.println("""
                1. Create Ticket\s
                2. Get All Tickets
                3. Search for Ticket
                4. Modify Tickets
                5. Exit
                """);
    }

    //menu for chose of Critera to when searching for the
    public void  chooseCritera(){
        System.out.println("******Select Critera to search********");
        System.out.println("""
                1. Customer Name
                2. Status
                3. Ticket Category
                """);
    }
    public void updateDeleteMenu(){
        System.out.println("*******Modify Ticket Menu********");
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
