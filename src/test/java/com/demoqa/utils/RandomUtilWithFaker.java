package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;


public class RandomUtilWithFaker {

    Faker faker = new Faker(new Locale("ru"));

    public String
            pictureFolder = "img/",
            pictureName = "1.jpeg",
            firstName = randomFirstName(),
            lastName = randomLastName(),
            userEmail = randomUserEmail(),
            userGender = randomGender(),
            userNumber = randomUserNumber(),
            userBirthDay = Integer.toString(randomDate()),
            userBirthMonth = randomMonth(),
            userBirthYear = Integer.toString(randomYear()),
            subject = randomSubject(),
            hobby = randomHobby(),
            userAddress = randomAddress(),
            userState = getRandomState(),
            userCity = getRandomCity(userState);

    public String randomFirstName() {
        return faker.name().firstName();
    }

    public String randomLastName() {
        return faker.name().lastName();
    }

    public String randomUserEmail() {
        return new Faker(new Locale("en")).internet().emailAddress();
    }

    public String randomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public String randomUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public int randomDate() {
        return faker.number().numberBetween(11, 28);
    }

    public String randomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return faker.options().option(month);
    }

    public int randomYear() {
        return faker.number().numberBetween(1930, 2015);
    }

    public String randomSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics", "Economics",
                "English", "Commerce", "Computer Science", "Physics", "Maths", "Hindi", "History", "Social Studies"};
        return faker.options().option(subjects);

    }

    public String randomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public String randomAddress() {
        return faker.address().streetAddress();
    }

    public String getRandomState() {

        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return faker.options().option(state);
    }

    public String getRandomCity(String stateValue) {


        switch (stateValue) {

            case "NCR" -> {
                String[] city = {"Delhi", "Gurgaon", "Noida"};
                return new Faker().options().option(city);
            }
            case "Uttar Pradesh" -> {
                String[] city = {"Agra", "Lucknow", "Merrut"};
                return new Faker().options().option(city);
            }
            case "Haryana" -> {
                String[] city = {"Karnal", "Panipat"};
                return new Faker().options().option(city);
            }
            case "Rajasthan" -> {
                String[] city = {"Jaipur", "Jaiselmer"};
                return new Faker().options().option(city);
            }
        }

        return null;
    }

}


