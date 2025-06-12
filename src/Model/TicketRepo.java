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

    public TicketSlip findTicketByCustomerName(String name) {
        for (TicketSlip ticket : tickets) {
            if (ticket.getCustomerName().equalsIgnoreCase(name)) {
                return ticket;
            }
        }
        return null;
    }
}
