package definitions;

import cucumber.api.java.en.Given;

public class JavaStepDefs {
    @Given("I write my string")
    public void iWriteMyString() {
        System.out.println("Hello World");
        //Declaring variables and print them out
        String txt = "Howdy";
        System.out.println(txt);
    }

    @Given("I join two strings")
    public void iJoinTwoStrings() {
        String firstName = "Rea";
        String lastName = "Tab";
        System.out.println("Hi, my name is " + firstName + " " + lastName);
    }

    @Given("I perform actions on {string} and {string}")
    public void iPerformActionsOnAnd(String var1, String var2) {
        System.out.println(var1 + " " + var2);
        System.out.println(var1.toUpperCase() + " " + var2.toLowerCase());
        System.out.println(var1.length());
        System.out.println(var2.length());
        System.out.println(var1.equals(var2));
        System.out.println(var1.equalsIgnoreCase(var2));
        String txt1 = "apple";
        String txt2 = "APPLE";
        System.out.println(txt1.equals(txt2));
        System.out.println(txt1.equalsIgnoreCase(txt2));
        String txt3 = "le";
        System.out.println(txt1.contains(txt3));
    }

    @Given("I calculate {int} and {int}")
    public void iCalculateAnd(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println(sum);
        System.out.println(num1 + num2);
        System.out.println(num1 / num2);
        float num4 = 3.0f;
        System.out.println(num1 + num4);
        double num5 = 4.00;
        System.out.println(num2 - num5);
        //comparing 2 numbers
        if (num1 > num2) {
            System.out.println(num1 + " is greater than " + num2);
        } else {
            System.out.println(num1 + " is less than " + num2);
        }
        //Boolean data type
        int num6=5;
        int num7=8;
        System.out.println(num6>num7);
        System.out.println(num1==num4);
        System.out.println(num2!=num5);
    }

    @Given("I want check number {int}")
    public void iWantCheckNumber(int num) {
        int mod=num%2;
        boolean result=mod==0;
        System.out.println("Number: "+num);
        System.out.println("Even: "+result);
    }

    @Given("I print url for {string}")
    public void iPrintUrlFor(String url) {
        if (url.equalsIgnoreCase("google")){
            System.out.println("http://google.com");
        } else if(url.equalsIgnoreCase("yahoo")){
            System.out.println("https://yahoo.com");
        } else if(url.equalsIgnoreCase("quote")) {
            System.out.println("https://skryabin.com/market/quote.html");
        } else{
            System.out.println("Unsupported website "+url);
        }
    }

    @Given("I select url for {string}")
    public void iSelectUrlFor(String url) {
        switch(url) {
            case "google":
                System.out.println("http://google.com");
                break;
            case "yahoo":
                System.out.println("https://yahoo.com");
                break;
            case "quote":
                System.out.println("https://skryabin.com/market/quote.html");
                break;
            case "amazon":
                System.out.println("www.amazon.com");
                break;
            default:
                System.out.println("Unknown url: "+url);
        }
    }

    @Given("I operate on array")
    public void iOperateOnArray() {
        String[] colors={"red", "yellow", "purple", "blue", "orange", "white"};
        System.out.println(colors); //doen't print array elements, but print location where array  is stored
        System.out.println(colors[0] );
        System.out.println(colors[3] );
        for (int i=0; i<colors.length; i++) {
            System.out.println(colors[i]);
        }

        // for each loop
        for (String elem:colors){
            System.out.println(elem);
        }

        // array of integers (using for each)
        int[] zipcodes ={95051, 95052, 95053, 95054, 95055};
        for(int el:zipcodes){
            System.out.println(el);
        }


    }
}
