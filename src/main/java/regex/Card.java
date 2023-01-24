package regex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Card {
    private long account;
    private String firstName;
    private String lastName;
    private int cvv;
    private int month;
    private int year;

    public void printCard() {
        System.out.printf("account : %-16d\t fullname : %-15s %-20s\t cvv : %-3d\t card expiry date : %02d/%d\n", account,firstName,lastName,cvv,month,year);
    }
}
