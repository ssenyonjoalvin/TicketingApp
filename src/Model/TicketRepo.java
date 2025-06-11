package Model;
import java.util.ArrayList;
import java.util.List;
public class TicketRepo {
    private List<TicketSlip> tickets = new ArrayList<>();

    public void addTicket(TicketSlip ticket) {
        tickets.add(ticket);
    }

    public List<TicketSlip> getAllTickets() {
        return tickets;
    }
}
