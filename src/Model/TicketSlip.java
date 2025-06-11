package Model;

public class TicketSlip {
    private String customerName;
    private int customerPhoneNumber;
    private String ticketCategory;
    private String issueDescription;
    private String dateOfCreation;
    private String assignedAgent;
    private String status;
    private String priority;
    private String additionalComments;
//setting setMethods for the attributes
    public void setCustomerName(String a){
        this.customerName = a;
    }
    public void setCustomerPhoneNumber(int b){
        this.customerPhoneNumber = b;
    }
    public void setTicketCategory(String c){
        this.ticketCategory = c;
    }
    public void setIssueDescription(String d){
        this.issueDescription = d;
    }
    public void setDateOfCreation(String e){
        this.dateOfCreation = e;
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
    public int getCustomerPhoneNumber(){
        return customerPhoneNumber;
    }
    public String getTicketCategory(){
        return ticketCategory;
    }
    public String getIssueDescription(){
        return issueDescription;
    }
    public String getDateOfCreation(){
        return dateOfCreation;
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
}
