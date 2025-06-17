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

    }
    //method returns the
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
            if (ticket.getCustomerName().equalsIgnoreCase(name)) {
                matched.add(ticket);
            }
        }
        return matched;
    }


    public List<TicketSlip> findTicketByStatus(TicketSlip.Status status) {
        List<TicketSlip> matched = new ArrayList<>();
        for (TicketSlip ticket : tickets) {
            if (ticket.getStatus() == (status)) {
                matched.add(ticket);
            }
        }
        return matched;
    }



    public List<TicketSlip>  findTicketByCategory(TicketSlip.Category  category) {
        List<TicketSlip> matched = new ArrayList<>();
        for (TicketSlip ticket : tickets) {
            if (ticket.getTicketCategory() == ( category)) {
                matched.add(ticket);
            }
        }
        return matched;
    }

}
