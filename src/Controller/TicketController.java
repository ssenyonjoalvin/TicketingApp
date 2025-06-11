package Controller;

import Model.TicketSlip;
import Model.TicketRepo;
import View.TicketView;
public class TicketController {

        private TicketView view;
        private TicketRepo repo;

        public TicketController(TicketView view, TicketRepo repo) {
            this.view = view;
            this.repo = repo;
        }

        public void createTicket() {
            String customerName = view.userInput("customerName");
            String customerPhoneNumber = view.userInput("phoneNumber");
            String ticketCategory = view.userInput("ticketCategory");
            String issueDescription = view.userInput("issueDescription");
            String dateOfCreation = view.userInput("dateOfCreation");
            String assignedAgent = view.userInput("assignedAgent");
            String status = view.userInput("status");
            String priority = view.userInput("priority");

            TicketSlip ticket = new TicketSlip(    customerName, customerPhoneNumber, ticketCategory, issueDescription, dateOfCreation, assignedAgent, status,priority);
            repo.addTicket(ticket);
            view.showMessage("Ticket created successfully!");
        }

        public void displayMenu() {
            while (true) {
                view.displayMenu();
                String choice = view.userInput("");

                switch (choice) {
                    case "1":
                        createTicket();
                        break;
                    case "2":
                        // View tickets (can be implemented next)
                        break;
                    case "3":
                        view.showMessage("Goodbye!");
                        return;
                    default:
                        view.showMessage("Invalid option.");
                }
            }
        }
    }


