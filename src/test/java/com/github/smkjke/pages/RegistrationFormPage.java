package com.github.smkjke.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.smkjke.pages.components.*;
import com.github.smkjke.testData.enums.Hobbies;
import com.github.smkjke.testData.enums.Subjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    UploadFileComponent uploadFileComponent = new UploadFileComponent();
    DropDownComponent dropDownComponent = new DropDownComponent();
    ButtonComponent buttonComponent = new ButtonComponent();


    private SelenideElement firstName = $x(".//input[@id='firstName']"),
            lastName = $x(".//input[@id='lastName']"),
            email = $x(".//input[@id='userEmail']"),
            phoneNumber = $x(".//input[@id='userNumber']"),
            currentAddress = $x(".//textarea[@id='currentAddress']");

    private static final String TITLE_TEXT = "Student Registration Form";


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $x(".//div[@class='practice-form-wrapper']").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    private WebElement getHobby(Hobbies hobbie) {
        return $x(String.format(".//label[contains(text()[normalize-space()], '%s')]", hobbie.toString()));
    }

    private WebElement getSubject(Subjects subjects) {
        return $x(".//div[contains(@class,'subjects-auto-complete__input')]//input").setValue(subjects.toString());
    }

    public RegistrationFormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $x(String.format(".//input[@value='%s' and @name='gender']/following-sibling::label", value)).click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(int day, String month, String year) {
        $x(".//input[@id='dateOfBirthInput']").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultTableComponent.isVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);
        return this;
    }

    public RegistrationFormPage setSubjects(List<Subjects> subjects) {
        subjects.forEach(a -> getSubject(a).sendKeys(Keys.ENTER));
        return this;
    }

    public RegistrationFormPage setHobbies(List<Hobbies> hobbies) {
        hobbies.forEach(a -> getHobby(a).click());
        return this;
    }

    public RegistrationFormPage uploadFile(File file) {
        uploadFileComponent.uploadFile("uploadPicture", file);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        dropDownComponent.setDropDown("city", city);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        dropDownComponent.setDropDown("state", state);
        return this;
    }

    public RegistrationFormPage submit() {
        buttonComponent.clickButton("submit");
        return this;
    }

}
