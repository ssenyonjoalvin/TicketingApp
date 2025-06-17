package Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketSlip {
    private int idCounter =1;
    private int  id;
    private String customerName;
    private String customerPhoneNumber;
    private Category ticketCategory;
    private String issueDescription;
    private LocalDateTime dateOfCreation;
    private String assignedAgent;
    private Status status;
    private Priority priority;
    private String additionalComments;

    public TicketSlip(String customerName, String customerPhoneNumber, Category ticketCategory, String issueDescription,
                       String assignedAgent, Priority priority,Status status) {
        id = idCounter++;
        this.customerName= customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.ticketCategory = ticketCategory;
        this.issueDescription = issueDescription;
        this.dateOfCreation = LocalDateTime.now();
        this.assignedAgent = assignedAgent;
        this.status = status;
        this.priority = priority;
    }
// enums
    public enum Priority{
         LOW,  MEDIUM, HIGH
}

public enum Status{
        PENDING, ONGOING, COMPLETE
}
public enum Category{
        TECH, SALES, MARKETING
}
    //setting setMethods for the attributes
    public void setCustomerName(String a){
        this.customerName = a;
    }
    public void setCustomerPhoneNumber(String b){
        this.customerPhoneNumber = b;
    }
    public void setTicketCategory(Category c){
        this.ticketCategory = c;
    }
    public void setIssueDescription(String d){
        this.issueDescription = d;
    }

    public void setAssignedAgent(String f){
        this.assignedAgent = f;
    }
    public void setStatus(Status g){
        this.status = g;
    }
    public void setPriority(Priority h){
        this.priority = h;
    }
    public void  setAdditionalComments(String n){
        this.additionalComments = n;
    }
    //getter for the attributes
    public String getCustomerName(){
        return customerName;
    }
    public String getCustomerPhoneNumber(){
        return customerPhoneNumber;
    }
    public Category getTicketCategory(){
        return ticketCategory;
    }
    public int getID(){
        return id;
    }
    public String getIssueDescription(){
        return issueDescription;
    }

    public  String getAssignedAgent(){
        return assignedAgent;
    }
    public Status getStatus(){
        return status;
    }
    public Priority getPriority(){
        return priority;
    }
    public String getAdditionalComments(){
        return additionalComments;
    }


    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Ticket Id :" +id +"\n"+
                "Customer Name : "+  customerName + "\n"+
          "Customer PhoneNumber : " +customerPhoneNumber+ "\n"+
         "Ticket Category : " +ticketCategory+ "\n"+
          "Issue Description : " +issueDescription+ "\n"+
        "Date of Creation : " + dateOfCreation.format(formatter) +"\n"+
         "Assigned Agent : "+ assignedAgent+ "\n"+
         "Status : "+status + "\n"+
         "Priority : "+priority+ "\n"+
        "Comments :  " + (additionalComments != null ? additionalComments : "None") + "\n";
    }
}


