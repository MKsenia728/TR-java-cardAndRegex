package regex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParsing {
    List<String> listOutput;

    public DataParsing() {
        this.listOutput = new ArrayList<>();
    }

    public void parse(List<String> listInput) {
        LocalDate localDate = LocalDate.now();
        int curYear = localDate.getYear() % 100;
        Pattern pattern = Pattern.compile("^(\\d{4})(\\d{4})(\\d{4})(\\d{4})([A-Z]?[a-z]+)_([A-Z]?[A-Za-z']+)(\\d{3})(0[1-9]|1[0-2])" +
                "(" + (curYear + 1) + "|" + (curYear + 2) + "|" + (curYear + 3) + "|" + (curYear + 4) + "|" + (curYear + 5) + ")");
        System.out.println("Use printf : ");
        for (String str : listInput) {
            Matcher matcher = pattern.matcher(str);
            listOutput.add(matcher.replaceAll("Номер карты : $1-$2-$3-$4 Имя : $5 Фамилия : $6 CVV : ($7) срок : $8/$9"));
            matcher = pattern.matcher(str);
            while (matcher.find()) {
                int accountP1 = Integer.parseInt(matcher.group(1));
                int accountP2 = Integer.parseInt(matcher.group(2));
                int accountP3 = Integer.parseInt(matcher.group(3));
                int accountP4 = Integer.parseInt(matcher.group(4));
                String firstName = matcher.group(5);
                String lastName = matcher.group(6);
                int cvv = Integer.parseInt(matcher.group(7));
                int month = Integer.parseInt(matcher.group(8));
                int year = Integer.parseInt(matcher.group(9));
                System.out.printf("Account:%04d**%04d**%04d*%04d** fullname:%-10s %-15s cvv:(%-3d) card expiry date:%02d/%02d\n",
                        accountP1,accountP2,accountP3,accountP4,firstName,lastName,cvv,month,year);
            }
        }
    }
}
