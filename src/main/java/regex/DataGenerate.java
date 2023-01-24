package regex;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Random;

public class DataGenerate {
    Faker faker = new Faker();
    Random random = new Random();

    public long generateAccount(){
        long account=random.nextInt(9)+1;
        for (int i = 1; i < 16; i++) {
            account = (long) (account * 10 + random.nextInt(10));
        }
        return account;
    }

    public int generateCVV(){
        return random.ints(100, 1000)
                .findFirst()
                .getAsInt();
    }

    public int generateMonth(){
        return random.nextInt(1,13);
    }

    public int generateYear(){
        LocalDate localDate = LocalDate.now();
        return localDate.getYear() % 100 + random.nextInt(1,6);
    }

    public String generateFirstName(){
        return faker.name().firstName();
    }
    public String generateLastName() {
        return faker.name().lastName();
    }
}
