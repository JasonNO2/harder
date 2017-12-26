public class AddMoneyThread implements Runnable{

    //private AccountModel accountModel;
    private AccountModel2 accountModel;
    private double money;

    @Override
    public void run() {
        accountModel.deposit(money);
    }

    public AddMoneyThread(AccountModel2 accountModel, double money) {
        this.accountModel = accountModel;
        this.money = money;
    }
}
