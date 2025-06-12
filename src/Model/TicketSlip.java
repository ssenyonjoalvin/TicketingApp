package Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketSlip {
    private static int IDCounter =1;
    private int ID;
    private String customerName;
    private String customerPhoneNumber;
    private String ticketCategory;
    private String issueDescription;
    private LocalDateTime dateOfCreation;
    private String assignedAgent;
    private String status;
    private String priority;
    private String additionalComments;

    public TicketSlip(String customerName, String customerPhoneNumber, String ticketCategory, String issueDescription,
                       String assignedAgent, String status, String priority) {
        this.ID = IDCounter++;
        this.customerName= customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.ticketCategory = ticketCategory;
        this.issueDescription = issueDescription;
        this.dateOfCreation = LocalDateTime.now();
        this.assignedAgent = assignedAgent;
        this.status = status;
        this.priority = priority;
    }

    //setting setMethods for the attributes
    public void setCustomerName(String a){
        this.customerName = a;
    }
    public void setCustomerPhoneNumber(String b){
        this.customerPhoneNumber = b;
    }
    public void setTicketCategory(String c){
        this.ticketCategory = c;
    }
    public void setIssueDescription(String d){
        this.issueDescription = d;
    }

    public void setAssignedAgent(String f){
        this.assignedAgent = f;
    }
    public void setStatus(String g){
        this.status = g;
    }
    public void setPriority(String h){
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
    public String getTicketCategory(){
        return ticketCategory;
    }
    public int getID(){
        return ID;
    }
    public String getIssueDescription(){
        return issueDescription;
    }

    public  String getAssignedAgent(){
        return assignedAgent;
    }
    public String getStatus(){
        return status;
    }
    public String getPriority(){
        return priority;
    }
    public String getAdditionalComments(){
        return additionalComments;
    }


    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Ticket Id :" +ID +"\n"+
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


