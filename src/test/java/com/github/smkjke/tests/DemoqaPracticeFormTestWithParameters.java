package com.github.smkjke.tests;

import com.github.smkjke.pages.RegistrationFormPage;
import com.github.smkjke.testData.FakerUser;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class        DemoqaPracticeFormTestWithParameters extends BaseTest {

    private final RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillDemoqaAutomationPracticeFormTestWithParams() {
        step("Enter user data", () ->
        {
            registrationFormPage.openPage()
                    .setFirstName(FakerUser.firstName)
                    .setLastName(FakerUser.lastName)
                    .setEmail(FakerUser.email)
                    .setGender(FakerUser.gender)
                    .setPhoneNumber(FakerUser.phoneNumber)
                    .setBirthDate(FakerUser.dateOfBirth.getDayOfMonth(),
                            String.valueOf(FakerUser.dateOfBirth.getMonthValue() - 1),
                            String.valueOf(FakerUser.dateOfBirth.getYear()))
                    .setSubjects(FakerUser.subjects)
                    .setHobbies(FakerUser.hobbies)
                    .uploadFile(FakerUser.file)
                    .setCurrentAddress(FakerUser.currentAddress)
                    .setState(FakerUser.state)
                    .setCity(FakerUser.city)
                    .submit();
        });

        step("Checks form is correct", () -> {
            registrationFormPage.checkResultsTableVisible();
            registrationFormPage.checkResult("Student Name", FakerUser.firstName + " " + FakerUser.lastName)
                    .checkResult("Student Email", FakerUser.email)
                    .checkResult("Gender", FakerUser.gender)
                    .checkResult("Mobile", FakerUser.phoneNumber)
                    .checkResult("Date of Birth", FakerUser.getFullBirthdayDateWithFormat())
                    .checkResult("Subjects", FakerUser.subjects.toString().replace("[", "").replace("]", ""))
                    .checkResult("Hobbies", FakerUser.hobbies.toString().replace("[", "").replace("]", ""))
                    .checkResult("Picture", FakerUser.file.getName())
                    .checkResult("Address", FakerUser.currentAddress)
                    .checkResult("State and City", FakerUser.state + " " + FakerUser.city);
        });
    }

}
