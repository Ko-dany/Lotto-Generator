package lottery;

import java.util.Arrays;
import java.util.Scanner;

public class Purchase {
    Scanner sc = new Scanner(System.in);

    private static Purchase p;
    public static Purchase getInstance(){
        if(p == null) p = new Purchase();
        return p;
    }
    public static void freeInstance(){
        p = null;
    }

    private Purchase(){}

    int[] customerNumbers = new int[6];
    String customerLottery = "";

    public void askPurchase(){
        Membership m = Membership.getInstance();

        System.out.println("Hi, "+ m.name +"!\n" +
                "Would you like to purchase a lottery ticket?\n" +
                "[1] Yes \t [2] No");
        String answer = "";

        for(;;){
            System.out.print("\nInput: ");
            answer = sc.next();

            if(answer.equals("1")){
                startLottery();
                System.out.println("=================================================================\n");
                break;
            }else if(answer.equals("2")){
                System.out.println("\nlottery.Lottery purchase is over.");
                System.exit(0);
            }else{
                System.out.println("\nInvalid input. Please try again.");
            }
        }
    }

    public int getLotteryNumber(int number){
        String tempNum;
        for(;;){
            System.out.print("["+(number+1)+"]"+"Please enter the number: ");
            tempNum = sc.next();
            if(tempNum.length() != 1){
                System.out.println("Please enter a 1-digit number. [ 0 - 9 ]");
            }else{
                return Integer.parseInt(tempNum);
            }
        }
    }

    public void startLottery(){
        System.out.println("\nPlease enter a total of 6 lottery numbers with 1 digit.");

        for(int i = 0; i < customerNumbers.length; i++){
            customerNumbers[i] = getLotteryNumber(i);
            customerLottery += "[" + Integer.toString(customerNumbers[i]) + "]";
        }
        Arrays.sort(customerNumbers);

        System.out.println("The numbers you entered is " + customerLottery +".\n" +
                "Would you like to proceed with the lottery purchase with these numbers?\n" +
                "[1] Yes \t [2] No");

        String answer = "";
        for(;;){
            System.out.print("\nInput: ");
            answer = sc.next();

            if(answer.equals("1")){
                orderLottery();
                break;
            }else if(answer.equals("2")){
                System.out.println("\nlottery.Lottery purchase is over.");
                System.exit(0);
            }else{
                System.out.println("\nInvalid input. Please try again.");
            }
        }
    }

    public void orderLottery(){
        Membership m = Membership.getInstance();
        String pw = "";

        for(;;){
            System.out.print("\nPlease enter your password: ");
            pw = sc.next();

            if(pw.equals(m.password)){
                System.out.println("\nThe payment has been completed.\n" +
                        "The lottery will be held in 3 seconds.");
                break;
            }else{
                System.out.println("The password is not correct. Please enter again.");
            }
        }
    }
}
