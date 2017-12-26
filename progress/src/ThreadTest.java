import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest{
    public static void main (String[] args){
        //AccountModel accountModel=new AccountModel();
        AccountModel2 accountModel=new AccountModel2();
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.execute(new AddMoneyThread(accountModel,1.0 ));
        }
        service.shutdown();
        while (!service.isTerminated()) {

        }
        System.out.println("账户余额:" + accountModel.getBalance());
    }
}
