package com.github.smkjke.testData;

import com.github.javafaker.Faker;
import com.github.smkjke.testData.enums.Hobbies;
import com.github.smkjke.testData.enums.Subjects;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
@Getter
@Setter
public class FakerUser {

    private static final Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String gender = faker.demographic().sex();
    public static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static LocalDate dateOfBirth = LocalDate.of(faker.number().numberBetween(1900, 2001)
            , faker.number().numberBetween(0, 11)
            , faker.number().numberBetween(10, 31));
    public static List<Subjects> subjects = List.of(Subjects.Maths, Subjects.Economics, Subjects.English);
    public static List<Hobbies> hobbies = List.of(Hobbies.Music, Hobbies.Reading, Hobbies.Sports);
    public static String currentAddress = faker.address().fullAddress();
    public static String state = "NCR";
    public static String city = "Delhi";
    public static File file = new File("src/test/resources/cat.jpg");


    public static String getFullBirthdayDateWithFormat() {
        return String.format("%d %s,%d", dateOfBirth.getDayOfMonth(), dateOfBirth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH), dateOfBirth.getYear());
    }

}
