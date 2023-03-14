public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(20000);
        System.out.println("Начальный баланс: " + account.getAmount() + " сом");

        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Вывод 6000 сомов прошел успешно. новый баланс: " + account.getAmount() + " сом");
            } catch (LimitException e) {
                double remainingAmount = e.getRemainingAmount();
                System.out.println(e.getMessage());
                System.out.println("Снятие остатка средств " + remainingAmount + "сом");

                try {
                    account.withDraw(2000);
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Окончательный баланс: " + account.getAmount() + " сом ");
                break;
            }
        }


    }

    }
