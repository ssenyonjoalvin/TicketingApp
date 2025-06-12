package Controller;

import java.sql.SQLOutput;
import java.util.*;

import Model.TicketSlip;
import Model.TicketRepo;
import View.TicketView;

public class TicketController {

        private TicketView view;
        private TicketRepo repo;
//class contructor
        public TicketController(TicketView view, TicketRepo repo) {
            this.view = view;
            this.repo = repo;
        }
//methods displays  question/instructions and store input from users
        public void createTicket() {
            String customerName = view.userInput("Enter customer name ");
            String customerPhoneNumber = view.userInput("Enter phone number ");
            String ticketCategory = view.userInput("Enter ticket category ");
            String issueDescription = view.userInput("Enter issue description ");
            String assignedAgent = view.userInput("Enter assigned agent ");
            String status = view.userInput("Enter status ");
            String priority = view.userInput("Enter priority ");

//here is an object of the ticket created and added to the arraylist
            TicketSlip ticket = new TicketSlip(customerName, customerPhoneNumber, ticketCategory, issueDescription, assignedAgent, status,priority);
            repo.addTicket(ticket);
            view.showMessage("Ticket created successfully!\n");
        }
//method d retrives all the tickets in the arraylist
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
//method allows users to update status of a ticket
  public void updateTicketInfo() {
        int Id = Integer.parseInt(view.userInput("Enter  of the ticket ticket Id  for ticket to update"));

        TicketSlip ticketToUpdate = repo.findTicketByID(Id);

        if (ticketToUpdate == null) {
            view.showMessage(" No ticket found for ticketId ! " +Id);
            return;
        }

        view.updateDeleteMenu(); //method displays menu for user to choice whether to delete or update
      String option = view.userInput(""); //input is stored here

      //check the option the user chose 1 for update and 2 for delete
      if(option.equals("1") ){
          String newStatus = view.userInput("Enter new status");
          String newPriority = view.userInput("Enter new priority");
          String newComments = view.userInput("Enter any additional comments");

          ticketToUpdate.setStatus(newStatus);
          ticketToUpdate.setPriority(newPriority);
          ticketToUpdate.setAdditionalComments(newComments);

          view.showMessage(" Ticket updated successfully!\n");
      }else {
          repo.deleteTicket(ticketToUpdate);
      }


    }
    //method looks through the arraylist and  returns the tickets
     public void SearchTickets(){
            view.chooseCritera(); //display the critera menu
            String searchOptions = view.userInput(""); //store it here

         //depending on the option chose , tickets are returned based on the critera chosen
            switch(searchOptions){
                //search by Customer Name
                case "1"  :
                String customerName = view.userInput("Enter customer name of the ticket to search for");
                List<TicketSlip>ticketSearchedByName = repo. findTicketByCustomerName(customerName);

                if (ticketSearchedByName == null)  {
                    System.out.println("No tickets found with the status: " + customerName);
                } else {
                    System.out.println("Tickets with status '" +customerName+ "':");
                    for (TicketSlip ticket : ticketSearchedByName) {
                        System.out.println(ticket);
                        System.out.println("------------------------");
                    }
                }
                break;

                    //search by ticket status
                case "2" :
                    String ticketStatus = view.userInput("Enter status of the tickets you are searching for:");
                    List<TicketSlip> ticketsByStatus = repo.findTicketByStatus(ticketStatus);

                    if ( ticketsByStatus.isEmpty()) {
                        System.out.println("No tickets found with the status: " + ticketStatus);
                    } else {
                        System.out.println("Tickets with status '" + ticketStatus + "':");
                        for (TicketSlip ticket : ticketsByStatus) {
                            System.out.println(ticket);
                            System.out.println("------------------------");
                        }
                    }
                    break;

                //search by ticket category
                case "3" :

                    String ticketCategory = view.userInput("Enter critera of the ticket you are searching for");
                    List<TicketSlip> ticketSearchedByCategory = repo. findTicketByCategory(ticketCategory);

                    if (ticketSearchedByCategory== null || ticketSearchedByCategory.isEmpty()) {
                        System.out.println("No tickets found with the status: " + ticketCategory);
                    } else {
                        System.out.println("Tickets with status '" + ticketCategory + "':");
                        for (TicketSlip ticket : ticketSearchedByCategory) {
                            System.out.println(ticket);
                            System.out.println("------------------------");
                        }
                    }
                    break;



            }
     }



        public void displayMenu() {
            boolean exit = false; // control the recurring of the display of the menu
            while (!exit) {
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
                        SearchTickets();
                        break;
                    case "4":
                        updateTicketInfo();
                        break;
                    case "5":
                    exit = true;
                        view.showMessage("You have exited the application");
                        break;
                    default:
                        view.showMessage("Invalid option.");
                }
            }
        }
    }


