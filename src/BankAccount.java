import java.util.Scanner;

public class BankAccount {
    private double amount;

    public BankAccount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }


    public void deposit(double som) {
        this.amount += som;
    }

    public void  withDraw (int som) throws LimitException{
        if (som > amount){
            throw new LimitException("Сумма вывода превышает баланс счета: " + amount );

        }amount -= som;


    }


}
