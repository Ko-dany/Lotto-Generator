package lottery;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Membership{

    // Created a singleton class
    private static Membership m;
    public static Membership getInstance(){
        if(m==null){
            m = new Membership();
        }
        return m;
    }
    public static void freeInstance(){
        m = null;
    }

    private Membership(){}
    Scanner sc = new Scanner(System.in);
    private static final String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    String name;
    String birthYear;
    String birthMonth;
    String birthDay;
    String email;
    String password;
    String address;

    public static boolean validateEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Introduce membership registration
    public void registerMembership() {

        System.out.println(
                " \n\n ##        ####    ######   ######   ######   #####    ##  ##  \r\n"
                    + " ##       ##  ##     ##       ##     ##       ##  ##   ##  ##  \r\n"
                    + " ##       ##  ##     ##       ##     #####    #####    ###### \r\n"
                    + " ##       ##  ##     ##       ##     ##       ## ##      ##    \r\n"
                    + " ######    ####      ##       ##     ######   ##  ##     ##");
        System.out.println("Hi, Welcome to Dany Lotto!.\n" +
                "You need to register our membership to purchase the lottery.\n" +
                "Do you want to register?\n" +
                "[1] Yes\t [2] No");
        String answer = "";

        // Ask options for registration
        for (; ; ) {
            System.out.print("\nInput: ");
            answer = sc.next();

            if (answer.equals("1")) {
                getRegistrationInfo();
                break;
            } else if (answer.equals("2")) {
                System.out.println("\nYou must be a member to make a purchase.");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public void getRegistrationInfo(){
        System.out.println("=================================================================");
        System.out.println("Please fill out the form below for membership registration.");

        System.out.print("* Name: ");
        this.name = sc.next();

        int tempYear = 0;
        int tempMonth = 0;
        int tempDay = 0;
        String tempEmail;

        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);

        // Validate the birth year
        for(;;){
            System.out.print("* Birth year: ");
            tempYear = Integer.parseInt(sc.next());

            if(tempYear == currentYear || (tempYear > currentYear - 20 && tempYear < currentYear)){
                System.out.println("Minors are not allowed to purchase lottery tickets.\n" +
                        "Registration will now be terminated.");
                System.exit(0);
            }else if(tempYear < 1900 || tempYear > currentYear){
                System.out.println("Invalid input.\n" +
                        "Please enter your birth year again.");
            }else{
                birthYear = Integer.toString(tempYear);
                break;
            }
        }

        // Validate month
        for(;;){
            System.out.print("* Birth Month: ");
            tempMonth = Integer.parseInt(sc.next());

            if(tempMonth == 0 || tempMonth > 12){
                System.out.println("Invalid input.\n" +
                        "Please enter your birth month again.");
            }else{
                birthMonth = Integer.toString(tempMonth);
                break;
            }
        }

        // Set up range of day depending on the month entered

        DatePrinter.printDateTime(cal);
        cal.set(Calendar.DAY_OF_MONTH, tempMonth);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(;;){
            System.out.print("* Birth day: ");
            tempDay = Integer.parseInt(sc.next());

            if(tempDay <= 0 || tempDay > maxDay){
                System.out.println("Invalid input.\n" +
                        "Please enter your birth day again.");
            }else{
                birthDay = Integer.toString(tempDay);
                break;
            }
        }

        for(;;){
            System.out.print("* E-mail: ");
            tempEmail = sc.next();

            if(!validateEmail(tempEmail)){
                System.out.println("Invalid email format.\n" +
                        "Please enter your email again.");
            }else{
                this.email = tempEmail;
                break;
            }

        }

        System.out.print("* Password: ");
        this.password = sc.next();

        System.out.print("* Address: ");
        this.address = sc.next();

        System.out.println("Your registration has been completed!");
        System.out.println("=================================================================\n");
    };

}
