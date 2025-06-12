package Model;
import java.util.ArrayList;
import java.util.List;
public class TicketRepo {
    private List<TicketSlip> tickets = new ArrayList<>();

    public void addTicket(TicketSlip ticket) {
        tickets.add(ticket);
    }

    public void deleteTicket(TicketSlip ticket){
        tickets.remove(ticket);
        System.out.println("Ticket has been delete!!!\n");
    }
    //metod returns the
    public List<TicketSlip> getAllTickets() {
        return tickets;
    }

    public TicketSlip findTicketByID(int Id) {
        for (TicketSlip ticket : tickets) {
            if (ticket.getID() == (Id)) {
                return ticket;
            }
        }
        return null;
    }

    public List<TicketSlip> findTicketByCustomerName(String name) {
        List<TicketSlip> matched = new ArrayList<>();
        for (TicketSlip ticket : tickets) {
            if (ticket.getStatus().equalsIgnoreCase(name)) {
                matched.add(ticket);
            }
        }
        return matched;
    }


    public List<TicketSlip> findTicketByStatus(String status) {
        List<TicketSlip> matched = new ArrayList<>();
        for (TicketSlip ticket : tickets) {
            if (ticket.getStatus().equalsIgnoreCase(status)) {
                matched.add(ticket);
            }
        }
        return matched;
    }


    public List<TicketSlip>  findTicketByCategory(String  category) {
        List<TicketSlip> matched = new ArrayList<>();
        for (TicketSlip ticket : tickets) {
            if (ticket.getStatus().equalsIgnoreCase( category)) {
                matched.add(ticket);
            }
        }
        return matched;
    }

}
