package tech.min.bharathacks;

/**
 * Created by rishabh on 17/6/17.
 */
public class StuffInCard {
    private String nameofuser;
    private String description;
    private String loanType;
    private String loanAmount;

    public StuffInCard(String nameofuser, String description, String loanType, String loanAmount) {
        this.nameofuser = nameofuser;
        this.description = description;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
    }

    public StuffInCard() {
    }

    public String getNameofuser() {
        return nameofuser;
    }

    public String getDescription() {
        return description;
    }

    public String getLoanType() {
        return loanType;
    }


    public String getLoanAmount() {
        return loanAmount;
    }

}
