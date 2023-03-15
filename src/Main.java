public class Main {
    public static void main(String[] args)  {

        BankAccount account = new BankAccount(20000);
        System.out.println("Начальный баланс счета:" + account.getAmount() + " сом");

        while (true) {
            try {
                account.withdraw(6000);
                System.out.println("Вывод успешен. Остаток средств: " + account.getAmount() + " сом ");
            } catch (LimitException e) {
                System.out.println(e.getMessage() + " Вывод остатка : " + e.getRemainingAmount() + " сом");
                try {
                    account.withdraw((int) e.getRemainingAmount());
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }  System.out.println("Окончательный баланс: " + account.getAmount() + " сом ");
                break;
            }
        }
    }
}




