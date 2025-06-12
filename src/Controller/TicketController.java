package Controller;

import java.util.*;

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
            String customerName = view.userInput("Enter customer name ");
            String customerPhoneNumber = view.userInput("Enter phone number ");
            String ticketCategory = view.userInput("Enter ticket category ");
            String issueDescription = view.userInput("Enter issue description ");
            String assignedAgent = view.userInput("Enter assigned agent ");
            String status = view.userInput("Enter status ");
            String priority = view.userInput("Enter priority ");


            TicketSlip ticket = new TicketSlip(customerName, customerPhoneNumber, ticketCategory, issueDescription, assignedAgent, status,priority);
            repo.addTicket(ticket);
            view.showMessage("Ticket created successfully!\n");
        }

    public void viewAllTickets() {
        List<TicketSlip> tickets = repo.getAllTickets();
        if (tickets.isEmpty()) {
            System.out.println("No tickets available!");
        } else {
            for (TicketSlip ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

  public void updateTicketInfo() {
        String customerName = view.userInput("Enter customer name of the ticket to update:");

        TicketSlip ticketToUpdate = repo.findTicketByCustomerName(customerName);

        if (ticketToUpdate == null) {
            view.showMessage(" No ticket found for customer: " + customerName);
            return;
        }
        view.updateDeleteMenu();
      String option = view.userInput("");
      if(option.equals("1") ){
          String newStatus = view.userInput("Enter new status:");
          String newPriority = view.userInput("Enter new priority:");
          String newComments = view.userInput("Enter any additional comments:");

          ticketToUpdate.setStatus(newStatus);
          ticketToUpdate.setPriority(newPriority);
          ticketToUpdate.setAdditionalComments(newComments);

          view.showMessage(" Ticket updated successfully!\n");
      }else {
          repo.deleteTicket(ticketToUpdate);
      }


    }

//    public void checkTicketStatus() {
//        String customerName = view.userInput("Enter customer name of the ticket to check status:");
//
//        TicketSlip ticket = repo.findTicketByCustomerName(customerName);
//
//        if (ticket != null) {
//            view.showMessage("Status: " + ticket.getStatus());
//        } else {
//            view.showMessage("Ticket for customer '" + customerName + "' not found.");
//        }
//    }

        public void displayMenu() {
            while (true) {
                view.displayMenu();
                String choice = view.userInput("");

                switch (choice) {
                    case "1":
                        createTicket();
                        break;
                    case "2":
                        viewAllTickets();
                        break;
                    case "3":
                     //   checkTicketStatus();
                        break;
                    case "4":
                        updateTicketInfo();
                        break;
                    default:
                        view.showMessage("Invalid option.");
                }
            }
        }
    }


