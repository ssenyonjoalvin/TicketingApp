//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Controller.TicketController;
import Model.TicketRepo;
import View.TicketView;

public class Main {
    public static void main(String[] args) {

                TicketView view = new TicketView(); //object of the view class that handles display to the console

                TicketRepo repo = new TicketRepo(); //object handles the arraylist methods of creation deletion and updating

                TicketController controller = new TicketController(view, repo); // this object connects both the view and the model

                controller.displayMenu(); // method displays main menu
            }
        }
