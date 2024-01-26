package lottery;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Lottery {
    int[] randomNumbers = new int[6];
    String lotteryNumbers = "";
    Loading l = new Loading();

    public static int getRandomRange(int min, int max){
        int num = (int)(Math.random() * (max - min + 1));
        return num;
    }

    public void getLotteryNumbers(){
        for(int i =0; i<6; i++){
            randomNumbers[i] = getRandomRange(0,9);
        }
        Arrays.sort(randomNumbers);
    }

    public void printLotteryNumbers(){

        for(int i=0; i<randomNumbers.length; i++){
            lotteryNumbers += "[" + Integer.toString(randomNumbers[i]) + "]";
        }

        System.out.println("The winning number for the lottery.\r\n" +
                "★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆\r\n" +
                "★☆★☆★☆★☆★☆★☆" + lotteryNumbers + "★☆★☆★☆★☆★☆★☆\n" +
                "★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar time = Calendar.getInstance();

        String formattedTime = dateFormat.format(time.getTime());
        System.out.println(formattedTime);

        System.out.println("\n=================================================================\n");
    }

    public void printResult(){
        Membership m = Membership.getInstance();
        Purchase p = Purchase.getInstance();

        System.out.println("Hi, " + m.name +
                ". The lottery result will be announced in 3 seconds.");
        System.out.println("\n=================================================================\n");

        l.loading();
        System.out.println("Your lottery number is " + p.customerLottery + ".");
        if(Arrays.equals(randomNumbers, p.customerNumbers)){
            System.out.println("Congratulations! You won the lottery.");
        }else{
            System.out.println("It's a draw. Go for the next opportunity.");
        }

        System.out.println("\n=================================================================");
        System.out.println("Lottery has been completed. Thank you.");
        System.out.println("=================================================================");


    }


}
