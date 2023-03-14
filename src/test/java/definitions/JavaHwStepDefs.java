package definitions;

import cucumber.api.java.en.Given;

public class JavaHwStepDefs {
    @Given("I provide my string")
    public void iProvideMyString() {
        //declare strings
        String greeting1;
        String greeting2;
        String greeting3;
        //initializing value of String variable
        greeting1 = "AhoY, mAtEy!";
        greeting2 = greeting1.toUpperCase();
        greeting3 = greeting1.toLowerCase();
        //printing strings
        System.out.println(greeting1);
        //printing string in upper cases
        System.out.println(greeting2);
        //printing string in lower cases
        System.out.println(greeting3);
        //exact comparison using .equals()
        System.out.println(greeting1.equals(greeting2));
        System.out.println(greeting1.equals(greeting3));
        System.out.println(greeting3.equals(greeting2));
        //comparison ignoring case using .equalsIgnoreCase()
        System.out.println(greeting1.equalsIgnoreCase(greeting2));
        System.out.println(greeting1.equalsIgnoreCase(greeting2));
        System.out.println(greeting3.equalsIgnoreCase(greeting2));
        //partial comparison using .contains()
        System.out.println(greeting1.contains("mat"));
        System.out.println(greeting2.contains("mat"));
        System.out.println(greeting3.contains("mat"));
    }

    @Given("I combine Strings {string}, {string}, {string}")
    public void iCombineStrings(String firstName, String lastName, String location) {
        //concatenation
        System.out.println("I am " + firstName + " " + lastName + ". I live in " + location + ".");
    }

    @Given("My age is {int}")
    public void myAgeIs(int age) {
        //Math operations
        int fivePlus = age + 5;
        int tenLess = age - 10;
        int twice = age * 2;
        double half = age / 2;
        int remainder = age % 2;
        boolean isEven = remainder == 0;

        System.out.println("I am " + age + "years old.");
        System.out.println("Five years from now, I will be " + fivePlus + " years old.");
        System.out.println("Ten years ago, I was " + tenLess + " years old.");
        System.out.println("Twice my age is " + twice + ".");
        System.out.println("Half my age is " + half + ".");
        System.out.println("Is " + age + ", an even number? " + isEven);
    }

    @Given("I want to count the letters in my string")
    public void iWantToCountTheLettersInMyString() {
        String firstWord = "pneumonoultramicroscopicsilicovolcanoconiosis";
        int firstCount = firstWord.length();
        System.out.println("The longest English word is " + firstWord + " which has " + firstCount + " letters.");
        String secondWord = "Pseudopseudohypoparathyroidism ";
        String thirdWord = "Supercalifragilisticexpialidocious";
        System.out.println("Is " + firstWord + " longer than " + secondWord + "? :" + (firstCount > secondWord.length()));
        System.out.println("Is " + thirdWord + " longer than " + secondWord + "? :" + (thirdWord.length() > secondWord.length()));
        System.out.println("Is " + secondWord + " longer than " + firstWord + "? :" + (secondWord.length() > firstCount));
    }

    @Given("I want to give examples to data types")
    public void iWantToGiveExamplesToDataTypes() {
        //examples of primitive data
        int myInt = 73;
        short myShort = 654;
        long myLong = 800903943;
        double myDouble = 3.141592653589793238;
        float myFloat = 43879.5f;
        char myChar = 'R';
        boolean myBoo = false;
        byte myByte = 123;
        System.out.println("Example of an integer: " + myInt);
        System.out.println("Example of a short: " + myShort);
        System.out.println("Example of a long: " + myLong);
        System.out.println("Example of a double: " + myDouble);
        System.out.println("Example of a float: " + myFloat);
        System.out.println("Example of a char: " + myChar);
        System.out.println("Example of a Boolean: " + myBoo);
        System.out.println("Example of a byte: " + myByte);
        //relational operators
        int x = 5;
        int y = 50;
        System.out.println(x == y);
        System.out.println(x != y);
        System.out.println(x > y);
        System.out.println(x < y);
        System.out.println(x >= y);
        System.out.println(x <= y);
    }

    @Given("Calculate BMI from height\\(m) and weight\\(kg)")
    public void calculateBMIFromHeightAndWeight() {
        //formula for BMI = weight/height squared
        int weight = 60;
        float height = 1.7f;
        float bmi = weight / (height * height);
        System.out.println("If your height is " + height + " meters and weighs " + weight + " kgs then, your Body Mass Index will be " + bmi + ".");
        //if... else condition
        if (bmi <= 18.5) {
            System.out.println("Your BMI is " + bmi + ", you are underweight.");
        } else if (bmi < 25) {
            System.out.println("Your BMI is " + bmi + ", you have a normal weight.");
        } else if (bmi < 30) {
            System.out.println("Your BMI is " + bmi + ", you are overweight.");
        } else {
            System.out.println("Your BMI is " + bmi + ", you are clinically obese.");
        }
    }

    // Switch homework
    @Given("I want to know what is month {int}")
    public void iWantToKnowWhatIsMonth(int month) {
        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("There are only 12 months in a year!");
        }
    }


    @Given("I list of grocery")
    public void iListOfGrocery() {
        // Array of Strings
        String[] groceryList = {"carrots", "celery", "tomato", "hummus", "chips", "ketchup" };
        // for loop
            for(int i=0; i<groceryList.length; i++ ){
               System.out.println(groceryList[i]);
            }
        // for each
            for(String el:groceryList){
                System.out.println(el);
            }
        // Array of Numbers
        int[] year = {2022, 2021, 2020, 2019, 2018, 2017, 2016};
         // for loop
            for (int i=0; i<year.length; i++) {
                System.out.println(year[i]);
            }
         // for each
            for(int num:year){
                System.out.println(num);
            }

    }
}


