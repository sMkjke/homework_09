package com.github.smkjke.testData;

import com.github.smkjke.testData.enums.Hobbies;
import com.github.smkjke.testData.enums.Subjects;

import java.io.File;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class BuilderSampleUser {

    String firstName;
    String lastName;
    String email;
    String gender;
    String phoneNumber;
    LocalDate dateOfBirth;
    List<Subjects> subjects;
    List<Hobbies> hobbies;
    String currentAddress;
    String state;
    String city;
    File file;

    private BuilderSampleUser(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        gender = builder.gender;
        phoneNumber = builder.phoneNumber;
        dateOfBirth = builder.dateOfBirth;
        subjects = builder.subjects;
        hobbies = builder.hobbies;
        currentAddress = builder.currentAddress;
        state = builder.state;
        city = builder.city;
        file = builder.file;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String gender;
        private String phoneNumber;
        private LocalDate dateOfBirth;
        private List<Subjects> subjects;
        private List<Hobbies> hobbies;
        private String currentAddress;
        private String state;
        private String city;
        private File file;

        public Builder() {
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder gender(String val) {
            gender = val;
            return this;
        }

        public Builder phoneNumber(String val) {
            phoneNumber = val;
            return this;
        }

        public Builder dateOfBirth(LocalDate val) {
            dateOfBirth = val;
            return this;
        }

        public Builder subject(List<Subjects> val) {
            subjects = val;
            return this;
        }

        public Builder hobbies(List<Hobbies> val) {
            hobbies = val;
            return this;
        }

        public Builder currentAddress(String val) {
            currentAddress = val;
            return this;
        }

        public Builder state(String val) {
            state = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder file(File val) {
            file = val;
            return this;
        }

        public BuilderSampleUser build() {
            return new BuilderSampleUser(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public List<Hobbies> getHobbies() {
        return hobbies;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public File getFile() {
        return file;
    }

    public String getFullBirthdayDateWithFormat() {
        return String.format("%d %s,%d", dateOfBirth.getDayOfMonth(), dateOfBirth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH), dateOfBirth.getYear());
    }

}
