//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Controller.TicketController;
import Model.TicketRepo;
import View.TicketView;

public class Main {
    public static void main(String[] args) {

                TicketView view = new TicketView();
                TicketRepo repo = new TicketRepo();
                TicketController controller = new TicketController(view, repo);
                controller.displayMenu();
            }
        }
