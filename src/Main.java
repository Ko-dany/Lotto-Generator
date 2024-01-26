import lottery.Loading;
import lottery.Lottery;
import lottery.Membership;
import lottery.Purchase;

public class Main {
    public static void main(String[] args) {
        Membership m = Membership.getInstance();
        m.registerMembership();
        Loading l = new Loading();

        Purchase p = Purchase.getInstance();
        p.askPurchase();
        l.loading();

        Lottery lt = new Lottery();

        lt.getLotteryNumbers();
        lt.printLotteryNumbers();
        lt.printResult();
    }
}