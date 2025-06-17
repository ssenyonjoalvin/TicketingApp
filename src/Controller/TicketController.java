package Controller;

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



    public String getValidatedPhoneNumber() {
    String phone;
    do {
        phone = view.userInput("Enter phone number: ");
        if (phone == null || phone.trim().isEmpty()) {
            view.showMessage("Phone number cannot be empty.");
            phone = null;
        } else if (!phone.matches("[+\\d\\s-]+")) {
            view.showMessage("Phone number must contain only digits, '+', '-', or spaces.");
            phone = null;
        } else {
            String clean = phone.replaceAll("[\\s-]", "");
            if (!(clean.length() == 10 || clean.length() == 13)) {
                view.showMessage("Number must be 10 digits (local) or 13 (with country code).");
                phone = null;
            } else if (clean.length() == 10 && !clean.startsWith("07")) {
                view.showMessage("Local phone number must start with '07'.");
                phone = null;
            } else if (clean.length() == 13 && !clean.startsWith("+256")) {
                view.showMessage("International phone must start with '+256'.");
                phone = null;
            } else {
                phone = clean;
            }
        }
    } while (phone == null);
    return phone;
}

  public String DescriptionValidations(){
            String desc;
      do {
         desc = view.userInput("Enter issue description ");
          if (   desc == null ||   desc.trim().isEmpty()) {
              view.showMessage("Description cannot be empty. Please try again!");
              desc = null;

          } else if (!   desc.matches("[a-zA-Z\\s.,'\"!?-]+")) {
              view.showMessage("Description must contain only letters, spaces, or basic punctuation. Please try again!");
              desc = null;

          } else if (desc.trim().length() < 5) {
              view.showMessage("Please enter a more detailed description (at least 5 characters). Try again!");
              desc = null;
          }

      } while (   desc == null);
     return desc;
  }

    private <E extends Enum<E>> E getValidatedEnumInput(String prompt, E[] values) {
        E result = null;
        while (result == null) {
            try {
                String input = view.userInput(prompt + " " + Arrays.toString(values) + ": ");
                result = Enum.valueOf(values[0].getDeclaringClass(), input.toUpperCase());
            } catch (IllegalArgumentException | NullPointerException e) {
                view.showMessage("Invalid input. Please enter one of: " + Arrays.toString(values));
            }
        }
        return result;
    }



    public void createTicket() {
            String customerName = nameValidator("Enter customer name");
            String customerPhoneNumber = getValidatedPhoneNumber(); //check if phone number  is not empty , if number  is 10 starts with 07 or 13 digit char must start with +256 .
            String issueDescription = DescriptionValidations();
            String assignedAgent = nameValidator("Enter Agent name");
             TicketSlip.Category category = getValidatedEnumInput("Enter category", TicketSlip.Category.values());
             TicketSlip.Status status = getValidatedEnumInput("Enter status", TicketSlip.Status.values());
             TicketSlip.Priority priority = getValidatedEnumInput("Enter priority", TicketSlip.Priority.values());

            //here is an object of the ticket created and added to the arraylist
            TicketSlip ticket = new TicketSlip(customerName, customerPhoneNumber,category, issueDescription, assignedAgent,priority, status);
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
        int id = Integer.parseInt(view.userInput("Enter  of the ticket ticket Id  for ticket to update"));
        TicketSlip ticketToUpdate = repo.findTicketByID(id);
        if (ticketToUpdate == null) {
            view.showMessage(" No ticket found for ticketId ! " +id);
            return;
        }

      //method displays menu for user to choice whether to delete or update
        view.updateDeleteMenu();
        String option = view.userInput(""); //input is stored here
      // check the option the user chose 1 for update and 2 for delete
      if (option.equals("1")) {
          // NAME
          String confrimation = view.userInput("Press 'y' to change customer name or 'Enter' to keep previous ");
          String newCustomerName = confrimation.isEmpty() ? ticketToUpdate.getCustomerName() : nameValidator("Enter new customer name");

          // PHONE
          String inputPhone = view.userInput("Enter new phone number (or press Enter to keep current) ");
          String newCustomerPhoneNumber = inputPhone.isEmpty() ? ticketToUpdate.getCustomerPhoneNumber() : getValidatedPhoneNumber();

          // DESCRIPTION
          String inputDescription = view.userInput("Press 'y' to change issue description or 'Enter' to keep previous ");
          String newIssueDescription = inputDescription.isEmpty() ? ticketToUpdate.getIssueDescription() : DescriptionValidations();

          // AGENT
          String inputAgent = view.userInput(" Press 'y' to change agent name or 'Enter' to keep previous ");
          String newAgent = inputAgent.isEmpty() ? ticketToUpdate.getAssignedAgent() : nameValidator("Enter new agent name");

          // ENUMS
          TicketSlip.Category category = ticketToUpdate.getTicketCategory();
          if (view.userInput("Change category? (y/n) ").equalsIgnoreCase("y")) {
              category = getValidatedEnumInput("Enter new category", TicketSlip.Category.values());
          }

          TicketSlip.Status status = ticketToUpdate.getStatus();
          if (view.userInput("Change status? (y/n): ").equalsIgnoreCase("y")) {
              status = getValidatedEnumInput("Enter new status", TicketSlip.Status.values());
          }

          TicketSlip.Priority priority = ticketToUpdate.getPriority();
          if (view.userInput("Change priority? (y/n): ").equalsIgnoreCase("y")) {
              priority = getValidatedEnumInput("Enter new priority", TicketSlip.Priority.values());
          }

          // COMMENTS
          String inputComments = view.userInput("Enter new comments (or press Enter to keep current): ");
          String newComments = inputComments.isEmpty() ? ticketToUpdate.getAdditionalComments() : inputComments;

          // UPDATE
          ticketToUpdate.setCustomerName(newCustomerName);
          ticketToUpdate.setCustomerPhoneNumber(newCustomerPhoneNumber);
          ticketToUpdate.setIssueDescription(newIssueDescription);
          ticketToUpdate.setAssignedAgent(newAgent);
          ticketToUpdate.setTicketCategory(category);
          ticketToUpdate.setStatus(status);
          ticketToUpdate.setPriority(priority);
          ticketToUpdate.setAdditionalComments(newComments);

          view.showMessage("Ticket updated successfully!\n");

      } else {
          repo.deleteTicket(ticketToUpdate);
          view.showMessage(" Ticket has been deleted!\n");
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
                    String customerName=  nameValidator("Enter name of customer to search "); //user can only enter letters for a name (not enter space nor numbers)
                    List<TicketSlip>ticketSearchedByName = repo. findTicketByCustomerName(customerName);
                    for (TicketSlip ticket : ticketSearchedByName) {
                        System.out.println(ticket);
                        System.out.println("------------------------");
                    }

                break;

                    //search by ticket status
                case "2" :
                    TicketSlip.Status status = getValidatedEnumInput("Enter status", TicketSlip.Status.values());
                            List<TicketSlip> ticketsByStatus = repo.findTicketByStatus(status);

                                for (TicketSlip ticket : ticketsByStatus) {
                                    System.out.println(ticket);
                                    view.showMessage("------------------------");
                                }

                    break;

                //search by ticket category
                case "3" :
                    TicketSlip.Category category = getValidatedEnumInput("Enter category", TicketSlip.Category.values());
                    List<TicketSlip> ticketSearchedByCategory = repo. findTicketByCategory(category);
                            for (TicketSlip ticket : ticketSearchedByCategory) {
                                System.out.println(ticket);
                                System.out.println("------------------------");
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

    private String nameValidator(String prompt) {
        String input;
        do {
            input = view.userInput(prompt);
            if (input == null || input.trim().isEmpty()) {
                view.showMessage("Input cannot be empty. Please try again.");
                input = null;
            } else if (!input.matches("[a-zA-Z ]+")) {
                view.showMessage("Input must contain letters only. Please try again.");
                input = null;
            }else if(input.length() < 3){
                view.showMessage("Input has to be atleast three characters long");
                input = null;
            }
        } while (input == null);
        return input.trim();
    }
}



