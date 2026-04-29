package regex;

public class Card {
    private long account;
    private String firstName;
    private String lastName;
    private int cvv;
    private int month;
    private int year;

    public Card(long account, String firstName, String lastName, int cvv, int month, int year) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cvv = cvv;
        this.month = month;
        this.year = year;
    }


    public void printCard() {
        System.out.printf("account : %-16d\t full name : %-15s %-20s\t cvv : %-3d\t card expiry date : %02d/%d%n", account,firstName,lastName,cvv,month,year);
    }

    public long getAccount() {
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCvv() {
        return cvv;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
