package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;


public class RandomUtilWithFaker {

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }
    
    Faker faker = new Faker(new Locale("ru"));

    public static
    String
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

    public static String randomFirstName() {
        return new Faker().name().firstName();
    }

    public static String randomLastName() {
        return new Faker().name().lastName();
    }

    public static String randomUserEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String randomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return new Faker().options().option(genders);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomUserNumber() {
        return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static int randomDate() {
        return new Faker().number().numberBetween(11, 28);
    }

    public static String randomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return new Faker().options().option(month);
    }

    public static int randomYear() {
        return new Faker().number().numberBetween(1930, 2015);
    }

    public static String randomSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics", "Economics",
                "English", "Commerce", "Computer Science", "Physics", "Maths", "Hindi", "History", "Social Studies"};
        return new Faker().options().option(subjects);

    }

    public static String randomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobbies);
    }

    public static String randomAddress() {
        return new Faker().address().streetAddress();
    }

    public static String getRandomState() {

        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return new Faker().options().option(state);
    }

    public static String getRandomCity(String stateValue) {


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


